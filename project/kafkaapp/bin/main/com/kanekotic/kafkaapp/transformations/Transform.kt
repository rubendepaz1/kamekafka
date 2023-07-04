package com.kanekotic.kafkaapp.transformations

import org.apache.kafka.streams.kstream.KStream

fun doStuff(topic: KStream<String, String>): KStream<String, String> {
    return topic.peek { _, value -> println(value) }
}