package com.kanekotic.kafkaapp.transformations

import org.apache.kafka.streams.kstream.KStream

fun doStuff(stream: KStream<String, String>): KStream<String, String> {
    return stream.peek { _, value -> println(value) }
}

