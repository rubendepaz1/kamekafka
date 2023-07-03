import org.apache.kafka.common.serialization.Serdes
import org.apache.kafka.streams.KafkaStreams
import org.apache.kafka.streams.StreamsBuilder
import org.apache.kafka.streams.StreamsConfig
import org.apache.kafka.streams.kstream.Consumed
import org.apache.kafka.streams.kstream.KStream
import java.util.*

fun doStuff(topic: KStream<String, String>): KStream<String, String> {
    return topic.peek { key, value -> println(value) }
}

fun main() {
    //configure
    val streamsBuilder = StreamsBuilder()
    val quickstart: KStream<String, String> = streamsBuilder
        .stream("quickstart", Consumed.with(Serdes.String(), Serdes.String()))
    //transform
    doStuff(quickstart)


    //consume
    val props = Properties()
    props["bootstrap.servers"] = "localhost:45597"
    props["application.id"] = "kafka-test"
    val streams = KafkaStreams(streamsBuilder.build(),props)
    streams.start()
}