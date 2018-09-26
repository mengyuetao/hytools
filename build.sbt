name := "hytool"
version := "0.1"
scalaVersion := "2.12.4"


libraryDependencies ++= Seq(
  "org.apache.avro" % "avro" % "1.8.2",
  "io.confluent" % "kafka-avro-serializer" % "5.0.0",
  "org.apache.kafka" % "kafka-clients" % "2.0.0",
  "org.apache.kafka" % "kafka_2.12" % "2.0.0")

resolvers += "confluent" at "http://packages.confluent.io/maven/"