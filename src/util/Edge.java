package util;

import java.util.Objects;

public class Edge <A>{
    A x;
    A y;
    public Edge(A x, A y){
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge<?> edge = (Edge<?>) o;
        return Objects.equals(x, edge.x) && Objects.equals(y, edge.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
