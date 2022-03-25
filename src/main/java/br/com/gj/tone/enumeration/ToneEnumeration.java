package br.com.gj.tone.enumeration;

public enum ToneEnumeration {

    PREFIX("#"),
    TOKEN(System.getenv("TOKEN")),
    RABBITMQ_HOST(System.getenv("RABBITMQ_HOST")),
    RABBITMQ_VIRTUAL_HOST(System.getenv("RABBITMQ_VIRTUAL_HOST")),
    RABBITMQ_USERNAME(System.getenv("RABBITMQ_USERNAME")),
    RABBITMQ_PASSWORD(System.getenv("RABBITMQ_PASSWORD"));

    private String value;

    ToneEnumeration(String value){
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }
}
