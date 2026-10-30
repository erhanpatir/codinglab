package common.model;

import java.util.List;

// LeetCode 339 / 341 için interface (LeetCode tarafından sağlanır).
public interface NestedInteger {
    boolean isInteger();
    Integer getInteger();
    List<NestedInteger> getList();
}
