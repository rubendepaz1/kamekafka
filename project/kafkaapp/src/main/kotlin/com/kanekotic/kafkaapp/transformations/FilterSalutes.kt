package com.kanekotic.kafkaapp.transformations

import org.apache.kafka.streams.kstream.KStream

fun filterSalutes(stream: KStream<String, String>): KStream<String, String> {
    return stream.filter { _, value -> value.contains("Hello") }
}