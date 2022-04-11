package edu.ucalgary.ensf409;

public enum ClientType {
    ADULTMALE {
        @Override
        public String toString() {
            return "ADULTMALE";
        }
    },
    ADULTFEMALE {
        @Override
        public String toString() {
            return "ADULTFEMALE";
        }
    },
    CHILDOVER8 {
        @Override
        public String toString() {
            return "CHILDOVER8";
        }
    },
    CHILDUNDER8 {
        @Override
        public String toString() {
            return "CHILDUNDER8";
        }
    }
}
