package com.kanekotic.kafkaapp.transformations

import com.kanekotic.kafkaapp.helpers.KafkaUnitTestBase
import org.apache.kafka.streams.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TransformTest: KafkaUnitTestBase<String, String>({ stream -> filterSalutes(stream)}, String::class.java, String::class.java) {

    @Test
    fun testFilterSalute() {
        inputTopic.pipeInput("key1", "Hello")
        inputTopic.pipeInput("key2", "pepepe")
        //inputTopic.pipeInput("key2", "hello world")
        assertEquals(outputTopic.queueSize, 1)
        assertEquals(outputTopic.readKeyValuesToList(), listOf(KeyValue("key1", "Hello")))
    }
}