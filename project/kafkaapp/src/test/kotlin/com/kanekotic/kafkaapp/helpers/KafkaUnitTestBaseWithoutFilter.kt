package com.kanekotic.kafkaapp.helpers

import org.apache.kafka.common.serialization.Serdes
import org.apache.kafka.streams.*
import org.apache.kafka.streams.kstream.Consumed
import org.apache.kafka.streams.kstream.KStream
import java.util.*

open class KafkaUnitTestBaseWithoutFilter<In,Out>(inClass: Class<In>, outClass: Class<Out>) {
    protected val inputTopic: TestInputTopic<String, In>
    protected val outputTopic: TestOutputTopic<String, Out>
    init {
        val builder = StreamsBuilder()
        builder.stream("input-topic", Consumed.with(Serdes.String(), Serdes.String()))
            .to("result-topic")
        val topology = builder.build()
        val props = Properties()
        props[StreamsConfig.APPLICATION_ID_CONFIG] = "test"
        props[StreamsConfig.BOOTSTRAP_SERVERS_CONFIG] = "dummy:1234"
        val testDriver = TopologyTestDriver(topology, props)
        inputTopic =
            testDriver.createInputTopic("input-topic", Serdes.String().serializer(), Serdes.serdeFrom(inClass).serializer())
        outputTopic =
            testDriver.createOutputTopic("result-topic", Serdes.String().deserializer(), Serdes.serdeFrom(outClass).deserializer())

    }
}