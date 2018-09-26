
import org.apache.avro.Schema;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericRecord;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.errors.SerializationException;
import java.util.Properties;

public class xxx {

    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);

        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "115.236.59.94:9092");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
                io.confluent.kafka.serializers.KafkaAvroSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
                io.confluent.kafka.serializers.KafkaAvroSerializer.class);
        props.put("schema.registry.url", "http://115.236.59.94:8081");
        KafkaProducer producer = new KafkaProducer(props);

        String key = "id_value1";
        String userSchema = "{\"type\":\"record\",\"name\":\"t_user_nlp_log\",\"fields\":[{\"name\":\"id\",\"type\":\"string\"},{\"name\":\"input_asr_text\",\"type\":\"string\",\"default\":\"\"},{\"name\":\"answer_text\",\"type\":\"string\",\"default\":\"\"},{\"name\":\"result\",\"type\":[\"string\",\"null\"]},{\"name\":\"msg_time\",\"type\":[\"string\",\"null\"]},{\"name\":\"mobile\",\"type\":[\"string\",\"null\"]},{\"name\":\"did\",\"type\":[\"string\",\"null\"]},{\"name\":\"file_path\",\"type\":\"string\",\"default\":\"\"},{\"name\":\"service_code\",\"type\":[\"string\",\"null\"]},{\"name\":\"msg_state\",\"type\":\"string\",\"default\":\"1\"},{\"name\":\"sid\",\"type\":[\"string\",\"null\"]},{\"name\":\"create_time\",\"type\":[\"string\",\"null\"]},{\"name\":\"update_time\",\"type\":[\"string\",\"null\"]}]}";
        Schema.Parser parser = new Schema.Parser();
        Schema schema = parser.parse(userSchema);
        GenericRecord avroRecord = new GenericData.Record(schema);
        avroRecord.put("id", "id_value1");
        avroRecord.put("input_asr_text", "input_asr_text_value1");
        avroRecord.put("answer_text", "answer_text_value1");
        avroRecord.put("result", "result_value1");
        avroRecord.put("msg_time", "msg_time_value1");
        avroRecord.put("mobile", "mobile_value1");
        avroRecord.put("did", "did_value1");
        avroRecord.put("file_path", "file_path_value1");
        avroRecord.put("service_code", "service_code_value1");
        avroRecord.put("msg_state", "msg_state_value1");
        avroRecord.put("sid", "sid_value1");
        avroRecord.put("create_time", "create_time_value1");
        avroRecord.put("update_time", "update_time_value1");


        ProducerRecord<Object, Object> record = new ProducerRecord<>("YYYYNL-t_user_nlp_log-18092501-value", key, avroRecord);
        try {
            for(int i=0;i<100;++i) {
                producer.send(record);
            }
            producer.flush();
            producer.close();
        } catch(Exception e) {
            // may need to do something with it
            e.printStackTrace();
        }
// When you're finished producing records, you can flush the producer to ensure it has all been written to Kafka and
// then close the producer to free its resources.
        finally {

        }
    }
}



