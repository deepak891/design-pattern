package com.designpattern.structural.facade.email;

public class Email {

    public Email(Builder emailBuilder){

    }

    public static class Builder {
        public Builder withTemplate(Template template){
            return this;
        }
        public Builder withStationary(Stationary stationary) {
            return this;
        }
        public Builder forObject(Object object) {
            return this;
        }

        public Email build(){
            return new Email(this);
        }
    }
}
