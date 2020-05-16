package ru.gb.jtwo.blesson.online;

public class CustomExeptionForArrLength extends Exception {
    private int length;
        public int getLength(){
            return length;
        }
        public CustomExeptionForArrLength(String msg, int length) {
            super(msg);
            this.length = length;
        }
}
