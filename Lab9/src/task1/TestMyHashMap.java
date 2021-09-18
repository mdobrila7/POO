package task1;

import java.util.Objects;

class TestMyHashMap {
    String s;
    TestMyHashMap(String s) {
        this.s = s;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestMyHashMap that = (TestMyHashMap) o;
        return Objects.equals(s, that.s);
    }

    @Override
    public int hashCode() {
        return Objects.hash(s);
    }
}
