package com.ivanov.model.entity;


public class Statistics {

    private String domain;
    private int count;

    //NoArgsCtr
    public Statistics() {
        this("", 0);
    }

    //AllArgsCtr
    public Statistics(String domain, int count) {
        this.domain = domain;
        this.count = count;
    }

    //Getter/setter
    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    //ToString
    @Override
    public String toString() {
        final char TAB = '\t';
        final String END_ROW = ";\n";

        StringBuilder sb = new StringBuilder(getClass().getSimpleName() + " {\n");

        sb.append(TAB).append("domain:").append(domain).append(END_ROW);
        sb.append(TAB).append("count:").append(count).append(END_ROW);
        sb.append('}');

        return sb.toString();
    }

    //Equals and Hashcode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || o.getClass() != this.getClass()) return false;
        Statistics that = (Statistics)o;
        if (this.getCount() != that.getCount()) return false;
        return this.getDomain().equals(that.getDomain());
    }
/*
    @Override
    public int hashCode() {
        final int prime = 113;

        int result = (getCount() ^ (getCount() >>> 32));
        result = prime * result + (getDomain() != null ? getDomain().hashCode() : 0);

        return result;
    }
*/

    @Override
    public int hashCode() {
        int result = domain.hashCode();
        result = 31 * result + count;
        return result;
    }
}
