public class HashEntry {
    private int key;
    private String value;
    private HashEntry nextHashEntry;

    public HashEntry(int key, String value) {
        this.key = key;
        this.value = value;
        this.nextHashEntry = null;
    }

    public int getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public HashEntry getNextHashEntry() {
        return nextHashEntry;
    }

    public void setNextHashEntry(HashEntry nextHashEntry) {
        this.nextHashEntry = nextHashEntry;
    }

    @Override
    public String toString() {
        return "HashEntry{" +
                "key=" + key +
                ", value='" + value + '\'' +
                ", nextHashEntry=" + nextHashEntry +
                '}';
    }
}
