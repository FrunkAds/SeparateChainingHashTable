import java.util.Arrays;

public class HashMap {
    private final static int TABLE_SIZE = 12;
    private HashEntry[] table;

    public HashMap() {
        table = new HashEntry[TABLE_SIZE];
        for (int i = 0; i < TABLE_SIZE; i++) {
            table[i] = null;
        }
    }

    public String get(int key) {
        int hash = (key % TABLE_SIZE);
        if (table[hash] == null) {
            throw new HashTableException("No matching key in the table");
        }else {
            HashEntry entry = table[hash];
            while (entry!=null && entry.getKey()!=key){
                entry  =entry.getNextHashEntry();
            }

            if(entry==null){
                throw new HashTableException("No matching key in the table");
            }else {
                return entry.getValue();
            }
        }
    }

    public void put(int key, String value) throws HashTableException {
        int hash = (key % TABLE_SIZE);
        if (table[hash] == null) {
            table[hash] = new HashEntry(key, value);
        } else {
            HashEntry entry = table[hash];
            while (entry.getNextHashEntry() != null && table[hash].getKey() != key) {
                entry = entry.getNextHashEntry();
            }
            if (entry.getKey() == key) {
                entry.setValue(value);
            } else {
                entry.setNextHashEntry(new HashEntry(key, value));
            }
        }
    }

    public void remove(int key) {
        int hash = (key % TABLE_SIZE);
        if(table[hash]!=null){
            HashEntry prevEntry = null;
            HashEntry entry = table[hash];

            while (entry.getNextHashEntry() != null && entry.getKey() != key){
                prevEntry = entry;
                entry = entry.getNextHashEntry();
            }

            if(entry.getKey()== key){
                if(prevEntry == null){
                    table[hash]=entry.getNextHashEntry();
                }else {
                    prevEntry.setNextHashEntry(entry.getNextHashEntry());
                }
            }
        }
    }

    @Override
    public String toString() {
        return "HashMap{" +
                "table=" + Arrays.toString(table) +
                '}';
    }
}
