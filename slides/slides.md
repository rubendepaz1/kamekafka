---
title: Foobar
separator: \n---\n
verticalSeparator: \n--\n
#theme: solarized
revealOptions:
  transition: 'fade'
---

# Kafka 101 🤓

---

# Why Apache Kafka

| Technology    | AWS Support | Maximum Retention | Connectors  | Schema registry        |
| ------------- | ----------- | ----------------- | ----------- | ---------------------- |
| Kafka         | Native      | Infinite          | Yes         | Native                 |
| Kinesis       | Native      | 365 days          | No          | Partial (Glue)         |
| Redis Streams | Partial     | Infinite          | No          | Partial (Avro)         |
| SQS           | Native      | 14 days           | No          | No                     |
| SNS           | Native      | No persistency    | No          | No                     |

Note: Kafka is the best choice meets our needs because: - Indefinite retention: if we want a store of events or domain objects we need them to be of indefinite existence, so that new products can be created from complete domain information. - Apply a data schema: so we can validate that data and services are compatible - automatically extract data from databases or Services: this will allow us to migrate more easily from our current environment. Otherwise it has to be done with training done by us. - Native support by AWS: We don't need to invest in maintaining and updating clusters ourselves.

---


