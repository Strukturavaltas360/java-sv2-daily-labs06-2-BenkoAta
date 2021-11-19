package day05;

public class ProductWithPiece {
    private Type type;
    private int count = 1;

    public ProductWithPiece(Type type) {
        this.type = type;
    }

    public void incrementCount() {
        count++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductWithPiece that = (ProductWithPiece) o;
        return type == that.type;
    }

    public Type getType() {
        return type;
    }

    public int getCount() {
        return count;
    }
}
