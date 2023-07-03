import com.nfeld.jsonpathkt.JsonPath
import com.nfeld.jsonpathkt.extension.read
import org.apache.kafka.common.serialization.Serdes
import org.apache.kafka.streams.KafkaStreams
import org.apache.kafka.streams.StreamsBuilder
import org.apache.kafka.streams.kstream.Consumed
import org.apache.kafka.streams.kstream.KStream
import java.io.File
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
    val kafkaConfig = File("/home/root/.confluent/config.json").readText(Charsets.UTF_8)
    val props = Properties()
    props["bootstrap.servers"] = "localhost:${JsonPath.parse(kafkaConfig)?.read<String>("$.local_ports.plaintext_port")}"
    props["application.id"] = "kafka-trial"
    val streams = KafkaStreams(streamsBuilder.build(),props)
    streams.start()
}