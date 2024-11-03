package software.ulpgc.es.model;

public class TsvTitleDeserializer implements TitleDeserializer {
    @Override
    public Title deserialize(String line) {
        return deserialize(line.split("\t"));
    }

    private Title deserialize(String[] fields) {
        return new Title(fields[3], toInt(fields[5]), toInt(fields[7]), fields[8]);
    }

    private int toInt(String field) {
        if (field.equals("\\N")) return 0;
        return Integer.parseInt(field);
    }
}
