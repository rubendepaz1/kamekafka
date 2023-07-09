package com.kanekotic.kafkaapp.transformations

import com.kanekotic.kafkaapp.helpers.KafkaUnitTestBase
import com.kanekotic.kafkaapp.helpers.KafkaUnitTestBaseWithoutFilter
import org.apache.kafka.streams.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class InputOutputTest: KafkaUnitTestBaseWithoutFilter<String, String>(String::class.java, String::class.java) {

    @Test
    fun testInputOutput() {
        inputTopic.pipeInput("key1", "Hello")
        inputTopic.pipeInput("key2", "pepepe")
        //inputTopic.pipeInput("key2", "hello world")
        assertEquals(outputTopic.queueSize, 2)
        assertEquals(outputTopic.readKeyValuesToList(), listOf(KeyValue("key1", "Hello"),KeyValue("key2", "pepepe")))
    }

}