import java.util.ArrayList;

public class makeGuess{
    private static int[][] all = {{0, 0, 0, 0}, {1, 0, 0, 0}, {2, 0, 0, 0}, {3, 0, 0, 0}, {4, 0, 0, 0}, {5, 0, 0, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}, {2, 1, 0, 0}, {3, 1, 0, 0}, {4, 1, 0, 0}, {5, 1, 0, 0}, {0, 2, 0, 0}, {1, 2, 0, 0}, {2, 2, 0, 0}, {3, 2, 0, 0}, {4, 2, 0, 0}, {5, 2, 0, 0}, {0, 3, 0, 0}, {1, 3, 0, 0}, {2, 3, 0, 0}, {3, 3, 0, 0}, {4, 3, 0, 0}, {5, 3, 0, 0}, {0, 4, 0, 0}, {1, 4, 0, 0}, {2, 4, 0, 0}, {3, 4, 0, 0}, {4, 4, 0, 0}, {5, 4, 0, 0}, {0, 5, 0, 0}, {1, 5, 0, 0}, {2, 5, 0, 0}, {3, 5, 0, 0}, {4, 5, 0, 0}, {5, 5, 0, 0}, {0, 0, 1, 0}, {1, 0, 1, 0}, {2, 0, 1, 0}, {3, 0, 1, 0}, {4, 0, 1, 0}, {5, 0, 1, 0}, {0, 1, 1, 0}, {1, 1, 1, 0}, {2, 1, 1, 0}, {3, 1, 1, 0}, {4, 1, 1, 0}, {5, 1, 1, 0}, {0, 2, 1, 0}, {1, 2, 1, 0}, {2, 2, 1, 0}, {3, 2, 1, 0}, {4, 2, 1, 0}, {5, 2, 1, 0}, {0, 3, 1, 0}, {1, 3, 1, 0}, {2, 3, 1, 0}, {3, 3, 1, 0}, {4, 3, 1, 0}, {5, 3, 1, 0}, {0, 4, 1, 0}, {1, 4, 1, 0}, {2, 4, 1, 0}, {3, 4, 1, 0}, {4, 4, 1, 0}, {5, 4, 1, 0}, {0, 5, 1, 0}, {1, 5, 1, 0}, {2, 5, 1, 0}, {3, 5, 1, 0}, {4, 5, 1, 0}, {5, 5, 1, 0}, {0, 0, 2, 0}, {1, 0, 2, 0}, {2, 0, 2, 0}, {3, 0, 2, 0}, {4, 0, 2, 0}, {5, 0, 2, 0}, {0, 1, 2, 0}, {1, 1, 2, 0}, {2, 1, 2, 0}, {3, 1, 2, 0}, {4, 1, 2, 0}, {5, 1, 2, 0}, {0, 2, 2, 0}, {1, 2, 2, 0}, {2, 2, 2, 0}, {3, 2, 2, 0}, {4, 2, 2, 0}, {5, 2, 2, 0}, {0, 3, 2, 0}, {1, 3, 2, 0}, {2, 3, 2, 0}, {3, 3, 2, 0}, {4, 3, 2, 0}, {5, 3, 2, 0}, {0, 4, 2, 0}, {1, 4, 2, 0}, {2, 4, 2, 0}, {3, 4, 2, 0}, {4, 4, 2, 0}, {5, 4, 2, 0}, {0, 5, 2, 0}, {1, 5, 2, 0}, {2, 5, 2, 0}, {3, 5, 2, 0}, {4, 5, 2, 0}, {5, 5, 2, 0}, {0, 0, 3, 0}, {1, 0, 3, 0}, {2, 0, 3, 0}, {3, 0, 3, 0}, {4, 0, 3, 0}, {5, 0, 3, 0}, {0, 1, 3, 0}, {1, 1, 3, 0}, {2, 1, 3, 0}, {3, 1, 3, 0}, {4, 1, 3, 0}, {5, 1, 3, 0}, {0, 2, 3, 0}, {1, 2, 3, 0}, {2, 2, 3, 0}, {3, 2, 3, 0}, {4, 2, 3, 0}, {5, 2, 3, 0}, {0, 3, 3, 0}, {1, 3, 3, 0}, {2, 3, 3, 0}, {3, 3, 3, 0}, {4, 3, 3, 0}, {5, 3, 3, 0}, {0, 4, 3, 0}, {1, 4, 3, 0}, {2, 4, 3, 0}, {3, 4, 3, 0}, {4, 4, 3, 0}, {5, 4, 3, 0}, {0, 5, 3, 0}, {1, 5, 3, 0}, {2, 5, 3, 0}, {3, 5, 3, 0}, {4, 5, 3, 0}, {5, 5, 3, 0}, {0, 0, 4, 0}, {1, 0, 4, 0}, {2, 0, 4, 0}, {3, 0, 4, 0}, {4, 0, 4, 0}, {5, 0, 4, 0}, {0, 1, 4, 0}, {1, 1, 4, 0}, {2, 1, 4, 0}, {3, 1, 4, 0}, {4, 1, 4, 0}, {5, 1, 4, 0}, {0, 2, 4, 0}, {1, 2, 4, 0}, {2, 2, 4, 0}, {3, 2, 4, 0}, {4, 2, 4, 0}, {5, 2, 4, 0}, {0, 3, 4, 0}, {1, 3, 4, 0}, {2, 3, 4, 0}, {3, 3, 4, 0}, {4, 3, 4, 0}, {5, 3, 4, 0}, {0, 4, 4, 0}, {1, 4, 4, 0}, {2, 4, 4, 0}, {3, 4, 4, 0}, {4, 4, 4, 0}, {5, 4, 4, 0}, {0, 5, 4, 0}, {1, 5, 4, 0}, {2, 5, 4, 0}, {3, 5, 4, 0}, {4, 5, 4, 0}, {5, 5, 4, 0}, {0, 0, 5, 0}, {1, 0, 5, 0}, {2, 0, 5, 0}, {3, 0, 5, 0}, {4, 0, 5, 0}, {5, 0, 5, 0}, {0, 1, 5, 0}, {1, 1, 5, 0}, {2, 1, 5, 0}, {3, 1, 5, 0}, {4, 1, 5, 0}, {5, 1, 5, 0}, {0, 2, 5, 0}, {1, 2, 5, 0}, {2, 2, 5, 0}, {3, 2, 5, 0}, {4, 2, 5, 0}, {5, 2, 5, 0}, {0, 3, 5, 0}, {1, 3, 5, 0}, {2, 3, 5, 0}, {3, 3, 5, 0}, {4, 3, 5, 0}, {5, 3, 5, 0}, {0, 4, 5, 0}, {1, 4, 5, 0}, {2, 4, 5, 0}, {3, 4, 5, 0}, {4, 4, 5, 0}, {5, 4, 5, 0}, {0, 5, 5, 0}, {1, 5, 5, 0}, {2, 5, 5, 0}, {3, 5, 5, 0}, {4, 5, 5, 0}, {5, 5, 5, 0}, {0, 0, 0, 1}, {1, 0, 0, 1}, {2, 0, 0, 1}, {3, 0, 0, 1}, {4, 0, 0, 1}, {5, 0, 0, 1}, {0, 1, 0, 1}, {1, 1, 0, 1}, {2, 1, 0, 1}, {3, 1, 0, 1}, {4, 1, 0, 1}, {5, 1, 0, 1}, {0, 2, 0, 1}, {1, 2, 0, 1}, {2, 2, 0, 1}, {3, 2, 0, 1}, {4, 2, 0, 1}, {5, 2, 0, 1}, {0, 3, 0, 1}, {1, 3, 0, 1}, {2, 3, 0, 1}, {3, 3, 0, 1}, {4, 3, 0, 1}, {5, 3, 0, 1}, {0, 4, 0, 1}, {1, 4, 0, 1}, {2, 4, 0, 1}, {3, 4, 0, 1}, {4, 4, 0, 1}, {5, 4, 0, 1}, {0, 5, 0, 1}, {1, 5, 0, 1}, {2, 5, 0, 1}, {3, 5, 0, 1}, {4, 5, 0, 1}, {5, 5, 0, 1}, {0, 0, 1, 1}, {1, 0, 1, 1}, {2, 0, 1, 1}, {3, 0, 1, 1}, {4, 0, 1, 1}, {5, 0, 1, 1}, {0, 1, 1, 1}, {1, 1, 1, 1}, {2, 1, 1, 1}, {3, 1, 1, 1}, {4, 1, 1, 1}, {5, 1, 1, 1}, {0, 2, 1, 1}, {1, 2, 1, 1}, {2, 2, 1, 1}, {3, 2, 1, 1}, {4, 2, 1, 1}, {5, 2, 1, 1}, {0, 3, 1, 1}, {1, 3, 1, 1}, {2, 3, 1, 1}, {3, 3, 1, 1}, {4, 3, 1, 1}, {5, 3, 1, 1}, {0, 4, 1, 1}, {1, 4, 1, 1}, {2, 4, 1, 1}, {3, 4, 1, 1}, {4, 4, 1, 1}, {5, 4, 1, 1}, {0, 5, 1, 1}, {1, 5, 1, 1}, {2, 5, 1, 1}, {3, 5, 1, 1}, {4, 5, 1, 1}, {5, 5, 1, 1}, {0, 0, 2, 1}, {1, 0, 2, 1}, {2, 0, 2, 1}, {3, 0, 2, 1}, {4, 0, 2, 1}, {5, 0, 2, 1}, {0, 1, 2, 1}, {1, 1, 2, 1}, {2, 1, 2, 1}, {3, 1, 2, 1}, {4, 1, 2, 1}, {5, 1, 2, 1}, {0, 2, 2, 1}, {1, 2, 2, 1}, {2, 2, 2, 1}, {3, 2, 2, 1}, {4, 2, 2, 1}, {5, 2, 2, 1}, {0, 3, 2, 1}, {1, 3, 2, 1}, {2, 3, 2, 1}, {3, 3, 2, 1}, {4, 3, 2, 1}, {5, 3, 2, 1}, {0, 4, 2, 1}, {1, 4, 2, 1}, {2, 4, 2, 1}, {3, 4, 2, 1}, {4, 4, 2, 1}, {5, 4, 2, 1}, {0, 5, 2, 1}, {1, 5, 2, 1}, {2, 5, 2, 1}, {3, 5, 2, 1}, {4, 5, 2, 1}, {5, 5, 2, 1}, {0, 0, 3, 1}, {1, 0, 3, 1}, {2, 0, 3, 1}, {3, 0, 3, 1}, {4, 0, 3, 1}, {5, 0, 3, 1}, {0, 1, 3, 1}, {1, 1, 3, 1}, {2, 1, 3, 1}, {3, 1, 3, 1}, {4, 1, 3, 1}, {5, 1, 3, 1}, {0, 2, 3, 1}, {1, 2, 3, 1}, {2, 2, 3, 1}, {3, 2, 3, 1}, {4, 2, 3, 1}, {5, 2, 3, 1}, {0, 3, 3, 1}, {1, 3, 3, 1}, {2, 3, 3, 1}, {3, 3, 3, 1}, {4, 3, 3, 1}, {5, 3, 3, 1}, {0, 4, 3, 1}, {1, 4, 3, 1}, {2, 4, 3, 1}, {3, 4, 3, 1}, {4, 4, 3, 1}, {5, 4, 3, 1}, {0, 5, 3, 1}, {1, 5, 3, 1}, {2, 5, 3, 1}, {3, 5, 3, 1}, {4, 5, 3, 1}, {5, 5, 3, 1}, {0, 0, 4, 1}, {1, 0, 4, 1}, {2, 0, 4, 1}, {3, 0, 4, 1}, {4, 0, 4, 1}, {5, 0, 4, 1}, {0, 1, 4, 1}, {1, 1, 4, 1}, {2, 1, 4, 1}, {3, 1, 4, 1}, {4, 1, 4, 1}, {5, 1, 4, 1}, {0, 2, 4, 1}, {1, 2, 4, 1}, {2, 2, 4, 1}, {3, 2, 4, 1}, {4, 2, 4, 1}, {5, 2, 4, 1}, {0, 3, 4, 1}, {1, 3, 4, 1}, {2, 3, 4, 1}, {3, 3, 4, 1}, {4, 3, 4, 1}, {5, 3, 4, 1}, {0, 4, 4, 1}, {1, 4, 4, 1}, {2, 4, 4, 1}, {3, 4, 4, 1}, {4, 4, 4, 1}, {5, 4, 4, 1}, {0, 5, 4, 1}, {1, 5, 4, 1}, {2, 5, 4, 1}, {3, 5, 4, 1}, {4, 5, 4, 1}, {5, 5, 4, 1}, {0, 0, 5, 1}, {1, 0, 5, 1}, {2, 0, 5, 1}, {3, 0, 5, 1}, {4, 0, 5, 1}, {5, 0, 5, 1}, {0, 1, 5, 1}, {1, 1, 5, 1}, {2, 1, 5, 1}, {3, 1, 5, 1}, {4, 1, 5, 1}, {5, 1, 5, 1}, {0, 2, 5, 1}, {1, 2, 5, 1}, {2, 2, 5, 1}, {3, 2, 5, 1}, {4, 2, 5, 1}, {5, 2, 5, 1}, {0, 3, 5, 1}, {1, 3, 5, 1}, {2, 3, 5, 1}, {3, 3, 5, 1}, {4, 3, 5, 1}, {5, 3, 5, 1}, {0, 4, 5, 1}, {1, 4, 5, 1}, {2, 4, 5, 1}, {3, 4, 5, 1}, {4, 4, 5, 1}, {5, 4, 5, 1}, {0, 5, 5, 1}, {1, 5, 5, 1}, {2, 5, 5, 1}, {3, 5, 5, 1}, {4, 5, 5, 1}, {5, 5, 5, 1}, {0, 0, 0, 2}, {1, 0, 0, 2}, {2, 0, 0, 2}, {3, 0, 0, 2}, {4, 0, 0, 2}, {5, 0, 0, 2}, {0, 1, 0, 2}, {1, 1, 0, 2}, {2, 1, 0, 2}, {3, 1, 0, 2}, {4, 1, 0, 2}, {5, 1, 0, 2}, {0, 2, 0, 2}, {1, 2, 0, 2}, {2, 2, 0, 2}, {3, 2, 0, 2}, {4, 2, 0, 2}, {5, 2, 0, 2}, {0, 3, 0, 2}, {1, 3, 0, 2}, {2, 3, 0, 2}, {3, 3, 0, 2}, {4, 3, 0, 2}, {5, 3, 0, 2}, {0, 4, 0, 2}, {1, 4, 0, 2}, {2, 4, 0, 2}, {3, 4, 0, 2}, {4, 4, 0, 2}, {5, 4, 0, 2}, {0, 5, 0, 2}, {1, 5, 0, 2}, {2, 5, 0, 2}, {3, 5, 0, 2}, {4, 5, 0, 2}, {5, 5, 0, 2}, {0, 0, 1, 2}, {1, 0, 1, 2}, {2, 0, 1, 2}, {3, 0, 1, 2}, {4, 0, 1, 2}, {5, 0, 1, 2}, {0, 1, 1, 2}, {1, 1, 1, 2}, {2, 1, 1, 2}, {3, 1, 1, 2}, {4, 1, 1, 2}, {5, 1, 1, 2}, {0, 2, 1, 2}, {1, 2, 1, 2}, {2, 2, 1, 2}, {3, 2, 1, 2}, {4, 2, 1, 2}, {5, 2, 1, 2}, {0, 3, 1, 2}, {1, 3, 1, 2}, {2, 3, 1, 2}, {3, 3, 1, 2}, {4, 3, 1, 2}, {5, 3, 1, 2}, {0, 4, 1, 2}, {1, 4, 1, 2}, {2, 4, 1, 2}, {3, 4, 1, 2}, {4, 4, 1, 2}, {5, 4, 1, 2}, {0, 5, 1, 2}, {1, 5, 1, 2}, {2, 5, 1, 2}, {3, 5, 1, 2}, {4, 5, 1, 2}, {5, 5, 1, 2}, {0, 0, 2, 2}, {1, 0, 2, 2}, {2, 0, 2, 2}, {3, 0, 2, 2}, {4, 0, 2, 2}, {5, 0, 2, 2}, {0, 1, 2, 2}, {1, 1, 2, 2}, {2, 1, 2, 2}, {3, 1, 2, 2}, {4, 1, 2, 2}, {5, 1, 2, 2}, {0, 2, 2, 2}, {1, 2, 2, 2}, {2, 2, 2, 2}, {3, 2, 2, 2}, {4, 2, 2, 2}, {5, 2, 2, 2}, {0, 3, 2, 2}, {1, 3, 2, 2}, {2, 3, 2, 2}, {3, 3, 2, 2}, {4, 3, 2, 2}, {5, 3, 2, 2}, {0, 4, 2, 2}, {1, 4, 2, 2}, {2, 4, 2, 2}, {3, 4, 2, 2}, {4, 4, 2, 2}, {5, 4, 2, 2}, {0, 5, 2, 2}, {1, 5, 2, 2}, {2, 5, 2, 2}, {3, 5, 2, 2}, {4, 5, 2, 2}, {5, 5, 2, 2}, {0, 0, 3, 2}, {1, 0, 3, 2}, {2, 0, 3, 2}, {3, 0, 3, 2}, {4, 0, 3, 2}, {5, 0, 3, 2}, {0, 1, 3, 2}, {1, 1, 3, 2}, {2, 1, 3, 2}, {3, 1, 3, 2}, {4, 1, 3, 2}, {5, 1, 3, 2}, {0, 2, 3, 2}, {1, 2, 3, 2}, {2, 2, 3, 2}, {3, 2, 3, 2}, {4, 2, 3, 2}, {5, 2, 3, 2}, {0, 3, 3, 2}, {1, 3, 3, 2}, {2, 3, 3, 2}, {3, 3, 3, 2}, {4, 3, 3, 2}, {5, 3, 3, 2}, {0, 4, 3, 2}, {1, 4, 3, 2}, {2, 4, 3, 2}, {3, 4, 3, 2}, {4, 4, 3, 2}, {5, 4, 3, 2}, {0, 5, 3, 2}, {1, 5, 3, 2}, {2, 5, 3, 2}, {3, 5, 3, 2}, {4, 5, 3, 2}, {5, 5, 3, 2}, {0, 0, 4, 2}, {1, 0, 4, 2}, {2, 0, 4, 2}, {3, 0, 4, 2}, {4, 0, 4, 2}, {5, 0, 4, 2}, {0, 1, 4, 2}, {1, 1, 4, 2}, {2, 1, 4, 2}, {3, 1, 4, 2}, {4, 1, 4, 2}, {5, 1, 4, 2}, {0, 2, 4, 2}, {1, 2, 4, 2}, {2, 2, 4, 2}, {3, 2, 4, 2}, {4, 2, 4, 2}, {5, 2, 4, 2}, {0, 3, 4, 2}, {1, 3, 4, 2}, {2, 3, 4, 2}, {3, 3, 4, 2}, {4, 3, 4, 2}, {5, 3, 4, 2}, {0, 4, 4, 2}, {1, 4, 4, 2}, {2, 4, 4, 2}, {3, 4, 4, 2}, {4, 4, 4, 2}, {5, 4, 4, 2}, {0, 5, 4, 2}, {1, 5, 4, 2}, {2, 5, 4, 2}, {3, 5, 4, 2}, {4, 5, 4, 2}, {5, 5, 4, 2}, {0, 0, 5, 2}, {1, 0, 5, 2}, {2, 0, 5, 2}, {3, 0, 5, 2}, {4, 0, 5, 2}, {5, 0, 5, 2}, {0, 1, 5, 2}, {1, 1, 5, 2}, {2, 1, 5, 2}, {3, 1, 5, 2}, {4, 1, 5, 2}, {5, 1, 5, 2}, {0, 2, 5, 2}, {1, 2, 5, 2}, {2, 2, 5, 2}, {3, 2, 5, 2}, {4, 2, 5, 2}, {5, 2, 5, 2}, {0, 3, 5, 2}, {1, 3, 5, 2}, {2, 3, 5, 2}, {3, 3, 5, 2}, {4, 3, 5, 2}, {5, 3, 5, 2}, {0, 4, 5, 2}, {1, 4, 5, 2}, {2, 4, 5, 2}, {3, 4, 5, 2}, {4, 4, 5, 2}, {5, 4, 5, 2}, {0, 5, 5, 2}, {1, 5, 5, 2}, {2, 5, 5, 2}, {3, 5, 5, 2}, {4, 5, 5, 2}, {5, 5, 5, 2}, {0, 0, 0, 3}, {1, 0, 0, 3}, {2, 0, 0, 3}, {3, 0, 0, 3}, {4, 0, 0, 3}, {5, 0, 0, 3}, {0, 1, 0, 3}, {1, 1, 0, 3}, {2, 1, 0, 3}, {3, 1, 0, 3}, {4, 1, 0, 3}, {5, 1, 0, 3}, {0, 2, 0, 3}, {1, 2, 0, 3}, {2, 2, 0, 3}, {3, 2, 0, 3}, {4, 2, 0, 3}, {5, 2, 0, 3}, {0, 3, 0, 3}, {1, 3, 0, 3}, {2, 3, 0, 3}, {3, 3, 0, 3}, {4, 3, 0, 3}, {5, 3, 0, 3}, {0, 4, 0, 3}, {1, 4, 0, 3}, {2, 4, 0, 3}, {3, 4, 0, 3}, {4, 4, 0, 3}, {5, 4, 0, 3}, {0, 5, 0, 3}, {1, 5, 0, 3}, {2, 5, 0, 3}, {3, 5, 0, 3}, {4, 5, 0, 3}, {5, 5, 0, 3}, {0, 0, 1, 3}, {1, 0, 1, 3}, {2, 0, 1, 3}, {3, 0, 1, 3}, {4, 0, 1, 3}, {5, 0, 1, 3}, {0, 1, 1, 3}, {1, 1, 1, 3}, {2, 1, 1, 3}, {3, 1, 1, 3}, {4, 1, 1, 3}, {5, 1, 1, 3}, {0, 2, 1, 3}, {1, 2, 1, 3}, {2, 2, 1, 3}, {3, 2, 1, 3}, {4, 2, 1, 3}, {5, 2, 1, 3}, {0, 3, 1, 3}, {1, 3, 1, 3}, {2, 3, 1, 3}, {3, 3, 1, 3}, {4, 3, 1, 3}, {5, 3, 1, 3}, {0, 4, 1, 3}, {1, 4, 1, 3}, {2, 4, 1, 3}, {3, 4, 1, 3}, {4, 4, 1, 3}, {5, 4, 1, 3}, {0, 5, 1, 3}, {1, 5, 1, 3}, {2, 5, 1, 3}, {3, 5, 1, 3}, {4, 5, 1, 3}, {5, 5, 1, 3}, {0, 0, 2, 3}, {1, 0, 2, 3}, {2, 0, 2, 3}, {3, 0, 2, 3}, {4, 0, 2, 3}, {5, 0, 2, 3}, {0, 1, 2, 3}, {1, 1, 2, 3}, {2, 1, 2, 3}, {3, 1, 2, 3}, {4, 1, 2, 3}, {5, 1, 2, 3}, {0, 2, 2, 3}, {1, 2, 2, 3}, {2, 2, 2, 3}, {3, 2, 2, 3}, {4, 2, 2, 3}, {5, 2, 2, 3}, {0, 3, 2, 3}, {1, 3, 2, 3}, {2, 3, 2, 3}, {3, 3, 2, 3}, {4, 3, 2, 3}, {5, 3, 2, 3}, {0, 4, 2, 3}, {1, 4, 2, 3}, {2, 4, 2, 3}, {3, 4, 2, 3}, {4, 4, 2, 3}, {5, 4, 2, 3}, {0, 5, 2, 3}, {1, 5, 2, 3}, {2, 5, 2, 3}, {3, 5, 2, 3}, {4, 5, 2, 3}, {5, 5, 2, 3}, {0, 0, 3, 3}, {1, 0, 3, 3}, {2, 0, 3, 3}, {3, 0, 3, 3}, {4, 0, 3, 3}, {5, 0, 3, 3}, {0, 1, 3, 3}, {1, 1, 3, 3}, {2, 1, 3, 3}, {3, 1, 3, 3}, {4, 1, 3, 3}, {5, 1, 3, 3}, {0, 2, 3, 3}, {1, 2, 3, 3}, {2, 2, 3, 3}, {3, 2, 3, 3}, {4, 2, 3, 3}, {5, 2, 3, 3}, {0, 3, 3, 3}, {1, 3, 3, 3}, {2, 3, 3, 3}, {3, 3, 3, 3}, {4, 3, 3, 3}, {5, 3, 3, 3}, {0, 4, 3, 3}, {1, 4, 3, 3}, {2, 4, 3, 3}, {3, 4, 3, 3}, {4, 4, 3, 3}, {5, 4, 3, 3}, {0, 5, 3, 3}, {1, 5, 3, 3}, {2, 5, 3, 3}, {3, 5, 3, 3}, {4, 5, 3, 3}, {5, 5, 3, 3}, {0, 0, 4, 3}, {1, 0, 4, 3}, {2, 0, 4, 3}, {3, 0, 4, 3}, {4, 0, 4, 3}, {5, 0, 4, 3}, {0, 1, 4, 3}, {1, 1, 4, 3}, {2, 1, 4, 3}, {3, 1, 4, 3}, {4, 1, 4, 3}, {5, 1, 4, 3}, {0, 2, 4, 3}, {1, 2, 4, 3}, {2, 2, 4, 3}, {3, 2, 4, 3}, {4, 2, 4, 3}, {5, 2, 4, 3}, {0, 3, 4, 3}, {1, 3, 4, 3}, {2, 3, 4, 3}, {3, 3, 4, 3}, {4, 3, 4, 3}, {5, 3, 4, 3}, {0, 4, 4, 3}, {1, 4, 4, 3}, {2, 4, 4, 3}, {3, 4, 4, 3}, {4, 4, 4, 3}, {5, 4, 4, 3}, {0, 5, 4, 3}, {1, 5, 4, 3}, {2, 5, 4, 3}, {3, 5, 4, 3}, {4, 5, 4, 3}, {5, 5, 4, 3}, {0, 0, 5, 3}, {1, 0, 5, 3}, {2, 0, 5, 3}, {3, 0, 5, 3}, {4, 0, 5, 3}, {5, 0, 5, 3}, {0, 1, 5, 3}, {1, 1, 5, 3}, {2, 1, 5, 3}, {3, 1, 5, 3}, {4, 1, 5, 3}, {5, 1, 5, 3}, {0, 2, 5, 3}, {1, 2, 5, 3}, {2, 2, 5, 3}, {3, 2, 5, 3}, {4, 2, 5, 3}, {5, 2, 5, 3}, {0, 3, 5, 3}, {1, 3, 5, 3}, {2, 3, 5, 3}, {3, 3, 5, 3}, {4, 3, 5, 3}, {5, 3, 5, 3}, {0, 4, 5, 3}, {1, 4, 5, 3}, {2, 4, 5, 3}, {3, 4, 5, 3}, {4, 4, 5, 3}, {5, 4, 5, 3}, {0, 5, 5, 3}, {1, 5, 5, 3}, {2, 5, 5, 3}, {3, 5, 5, 3}, {4, 5, 5, 3}, {5, 5, 5, 3}, {0, 0, 0, 4}, {1, 0, 0, 4}, {2, 0, 0, 4}, {3, 0, 0, 4}, {4, 0, 0, 4}, {5, 0, 0, 4}, {0, 1, 0, 4}, {1, 1, 0, 4}, {2, 1, 0, 4}, {3, 1, 0, 4}, {4, 1, 0, 4}, {5, 1, 0, 4}, {0, 2, 0, 4}, {1, 2, 0, 4}, {2, 2, 0, 4}, {3, 2, 0, 4}, {4, 2, 0, 4}, {5, 2, 0, 4}, {0, 3, 0, 4}, {1, 3, 0, 4}, {2, 3, 0, 4}, {3, 3, 0, 4}, {4, 3, 0, 4}, {5, 3, 0, 4}, {0, 4, 0, 4}, {1, 4, 0, 4}, {2, 4, 0, 4}, {3, 4, 0, 4}, {4, 4, 0, 4}, {5, 4, 0, 4}, {0, 5, 0, 4}, {1, 5, 0, 4}, {2, 5, 0, 4}, {3, 5, 0, 4}, {4, 5, 0, 4}, {5, 5, 0, 4}, {0, 0, 1, 4}, {1, 0, 1, 4}, {2, 0, 1, 4}, {3, 0, 1, 4}, {4, 0, 1, 4}, {5, 0, 1, 4}, {0, 1, 1, 4}, {1, 1, 1, 4}, {2, 1, 1, 4}, {3, 1, 1, 4}, {4, 1, 1, 4}, {5, 1, 1, 4}, {0, 2, 1, 4}, {1, 2, 1, 4}, {2, 2, 1, 4}, {3, 2, 1, 4}, {4, 2, 1, 4}, {5, 2, 1, 4}, {0, 3, 1, 4}, {1, 3, 1, 4}, {2, 3, 1, 4}, {3, 3, 1, 4}, {4, 3, 1, 4}, {5, 3, 1, 4}, {0, 4, 1, 4}, {1, 4, 1, 4}, {2, 4, 1, 4}, {3, 4, 1, 4}, {4, 4, 1, 4}, {5, 4, 1, 4}, {0, 5, 1, 4}, {1, 5, 1, 4}, {2, 5, 1, 4}, {3, 5, 1, 4}, {4, 5, 1, 4}, {5, 5, 1, 4}, {0, 0, 2, 4}, {1, 0, 2, 4}, {2, 0, 2, 4}, {3, 0, 2, 4}, {4, 0, 2, 4}, {5, 0, 2, 4}, {0, 1, 2, 4}, {1, 1, 2, 4}, {2, 1, 2, 4}, {3, 1, 2, 4}, {4, 1, 2, 4}, {5, 1, 2, 4}, {0, 2, 2, 4}, {1, 2, 2, 4}, {2, 2, 2, 4}, {3, 2, 2, 4}, {4, 2, 2, 4}, {5, 2, 2, 4}, {0, 3, 2, 4}, {1, 3, 2, 4}, {2, 3, 2, 4}, {3, 3, 2, 4}, {4, 3, 2, 4}, {5, 3, 2, 4}, {0, 4, 2, 4}, {1, 4, 2, 4}, {2, 4, 2, 4}, {3, 4, 2, 4}, {4, 4, 2, 4}, {5, 4, 2, 4}, {0, 5, 2, 4}, {1, 5, 2, 4}, {2, 5, 2, 4}, {3, 5, 2, 4}, {4, 5, 2, 4}, {5, 5, 2, 4}, {0, 0, 3, 4}, {1, 0, 3, 4}, {2, 0, 3, 4}, {3, 0, 3, 4}, {4, 0, 3, 4}, {5, 0, 3, 4}, {0, 1, 3, 4}, {1, 1, 3, 4}, {2, 1, 3, 4}, {3, 1, 3, 4}, {4, 1, 3, 4}, {5, 1, 3, 4}, {0, 2, 3, 4}, {1, 2, 3, 4}, {2, 2, 3, 4}, {3, 2, 3, 4}, {4, 2, 3, 4}, {5, 2, 3, 4}, {0, 3, 3, 4}, {1, 3, 3, 4}, {2, 3, 3, 4}, {3, 3, 3, 4}, {4, 3, 3, 4}, {5, 3, 3, 4}, {0, 4, 3, 4}, {1, 4, 3, 4}, {2, 4, 3, 4}, {3, 4, 3, 4}, {4, 4, 3, 4}, {5, 4, 3, 4}, {0, 5, 3, 4}, {1, 5, 3, 4}, {2, 5, 3, 4}, {3, 5, 3, 4}, {4, 5, 3, 4}, {5, 5, 3, 4}, {0, 0, 4, 4}, {1, 0, 4, 4}, {2, 0, 4, 4}, {3, 0, 4, 4}, {4, 0, 4, 4}, {5, 0, 4, 4}, {0, 1, 4, 4}, {1, 1, 4, 4}, {2, 1, 4, 4}, {3, 1, 4, 4}, {4, 1, 4, 4}, {5, 1, 4, 4}, {0, 2, 4, 4}, {1, 2, 4, 4}, {2, 2, 4, 4}, {3, 2, 4, 4}, {4, 2, 4, 4}, {5, 2, 4, 4}, {0, 3, 4, 4}, {1, 3, 4, 4}, {2, 3, 4, 4}, {3, 3, 4, 4}, {4, 3, 4, 4}, {5, 3, 4, 4}, {0, 4, 4, 4}, {1, 4, 4, 4}, {2, 4, 4, 4}, {3, 4, 4, 4}, {4, 4, 4, 4}, {5, 4, 4, 4}, {0, 5, 4, 4}, {1, 5, 4, 4}, {2, 5, 4, 4}, {3, 5, 4, 4}, {4, 5, 4, 4}, {5, 5, 4, 4}, {0, 0, 5, 4}, {1, 0, 5, 4}, {2, 0, 5, 4}, {3, 0, 5, 4}, {4, 0, 5, 4}, {5, 0, 5, 4}, {0, 1, 5, 4}, {1, 1, 5, 4}, {2, 1, 5, 4}, {3, 1, 5, 4}, {4, 1, 5, 4}, {5, 1, 5, 4}, {0, 2, 5, 4}, {1, 2, 5, 4}, {2, 2, 5, 4}, {3, 2, 5, 4}, {4, 2, 5, 4}, {5, 2, 5, 4}, {0, 3, 5, 4}, {1, 3, 5, 4}, {2, 3, 5, 4}, {3, 3, 5, 4}, {4, 3, 5, 4}, {5, 3, 5, 4}, {0, 4, 5, 4}, {1, 4, 5, 4}, {2, 4, 5, 4}, {3, 4, 5, 4}, {4, 4, 5, 4}, {5, 4, 5, 4}, {0, 5, 5, 4}, {1, 5, 5, 4}, {2, 5, 5, 4}, {3, 5, 5, 4}, {4, 5, 5, 4}, {5, 5, 5, 4}, {0, 0, 0, 5}, {1, 0, 0, 5}, {2, 0, 0, 5}, {3, 0, 0, 5}, {4, 0, 0, 5}, {5, 0, 0, 5}, {0, 1, 0, 5}, {1, 1, 0, 5}, {2, 1, 0, 5}, {3, 1, 0, 5}, {4, 1, 0, 5}, {5, 1, 0, 5}, {0, 2, 0, 5}, {1, 2, 0, 5}, {2, 2, 0, 5}, {3, 2, 0, 5}, {4, 2, 0, 5}, {5, 2, 0, 5}, {0, 3, 0, 5}, {1, 3, 0, 5}, {2, 3, 0, 5}, {3, 3, 0, 5}, {4, 3, 0, 5}, {5, 3, 0, 5}, {0, 4, 0, 5}, {1, 4, 0, 5}, {2, 4, 0, 5}, {3, 4, 0, 5}, {4, 4, 0, 5}, {5, 4, 0, 5}, {0, 5, 0, 5}, {1, 5, 0, 5}, {2, 5, 0, 5}, {3, 5, 0, 5}, {4, 5, 0, 5}, {5, 5, 0, 5}, {0, 0, 1, 5}, {1, 0, 1, 5}, {2, 0, 1, 5}, {3, 0, 1, 5}, {4, 0, 1, 5}, {5, 0, 1, 5}, {0, 1, 1, 5}, {1, 1, 1, 5}, {2, 1, 1, 5}, {3, 1, 1, 5}, {4, 1, 1, 5}, {5, 1, 1, 5}, {0, 2, 1, 5}, {1, 2, 1, 5}, {2, 2, 1, 5}, {3, 2, 1, 5}, {4, 2, 1, 5}, {5, 2, 1, 5}, {0, 3, 1, 5}, {1, 3, 1, 5}, {2, 3, 1, 5}, {3, 3, 1, 5}, {4, 3, 1, 5}, {5, 3, 1, 5}, {0, 4, 1, 5}, {1, 4, 1, 5}, {2, 4, 1, 5}, {3, 4, 1, 5}, {4, 4, 1, 5}, {5, 4, 1, 5}, {0, 5, 1, 5}, {1, 5, 1, 5}, {2, 5, 1, 5}, {3, 5, 1, 5}, {4, 5, 1, 5}, {5, 5, 1, 5}, {0, 0, 2, 5}, {1, 0, 2, 5}, {2, 0, 2, 5}, {3, 0, 2, 5}, {4, 0, 2, 5}, {5, 0, 2, 5}, {0, 1, 2, 5}, {1, 1, 2, 5}, {2, 1, 2, 5}, {3, 1, 2, 5}, {4, 1, 2, 5}, {5, 1, 2, 5}, {0, 2, 2, 5}, {1, 2, 2, 5}, {2, 2, 2, 5}, {3, 2, 2, 5}, {4, 2, 2, 5}, {5, 2, 2, 5}, {0, 3, 2, 5}, {1, 3, 2, 5}, {2, 3, 2, 5}, {3, 3, 2, 5}, {4, 3, 2, 5}, {5, 3, 2, 5}, {0, 4, 2, 5}, {1, 4, 2, 5}, {2, 4, 2, 5}, {3, 4, 2, 5}, {4, 4, 2, 5}, {5, 4, 2, 5}, {0, 5, 2, 5}, {1, 5, 2, 5}, {2, 5, 2, 5}, {3, 5, 2, 5}, {4, 5, 2, 5}, {5, 5, 2, 5}, {0, 0, 3, 5}, {1, 0, 3, 5}, {2, 0, 3, 5}, {3, 0, 3, 5}, {4, 0, 3, 5}, {5, 0, 3, 5}, {0, 1, 3, 5}, {1, 1, 3, 5}, {2, 1, 3, 5}, {3, 1, 3, 5}, {4, 1, 3, 5}, {5, 1, 3, 5}, {0, 2, 3, 5}, {1, 2, 3, 5}, {2, 2, 3, 5}, {3, 2, 3, 5}, {4, 2, 3, 5}, {5, 2, 3, 5}, {0, 3, 3, 5}, {1, 3, 3, 5}, {2, 3, 3, 5}, {3, 3, 3, 5}, {4, 3, 3, 5}, {5, 3, 3, 5}, {0, 4, 3, 5}, {1, 4, 3, 5}, {2, 4, 3, 5}, {3, 4, 3, 5}, {4, 4, 3, 5}, {5, 4, 3, 5}, {0, 5, 3, 5}, {1, 5, 3, 5}, {2, 5, 3, 5}, {3, 5, 3, 5}, {4, 5, 3, 5}, {5, 5, 3, 5}, {0, 0, 4, 5}, {1, 0, 4, 5}, {2, 0, 4, 5}, {3, 0, 4, 5}, {4, 0, 4, 5}, {5, 0, 4, 5}, {0, 1, 4, 5}, {1, 1, 4, 5}, {2, 1, 4, 5}, {3, 1, 4, 5}, {4, 1, 4, 5}, {5, 1, 4, 5}, {0, 2, 4, 5}, {1, 2, 4, 5}, {2, 2, 4, 5}, {3, 2, 4, 5}, {4, 2, 4, 5}, {5, 2, 4, 5}, {0, 3, 4, 5}, {1, 3, 4, 5}, {2, 3, 4, 5}, {3, 3, 4, 5}, {4, 3, 4, 5}, {5, 3, 4, 5}, {0, 4, 4, 5}, {1, 4, 4, 5}, {2, 4, 4, 5}, {3, 4, 4, 5}, {4, 4, 4, 5}, {5, 4, 4, 5}, {0, 5, 4, 5}, {1, 5, 4, 5}, {2, 5, 4, 5}, {3, 5, 4, 5}, {4, 5, 4, 5}, {5, 5, 4, 5}, {0, 0, 5, 5}, {1, 0, 5, 5}, {2, 0, 5, 5}, {3, 0, 5, 5}, {4, 0, 5, 5}, {5, 0, 5, 5}, {0, 1, 5, 5}, {1, 1, 5, 5}, {2, 1, 5, 5}, {3, 1, 5, 5}, {4, 1, 5, 5}, {5, 1, 5, 5}, {0, 2, 5, 5}, {1, 2, 5, 5}, {2, 2, 5, 5}, {3, 2, 5, 5}, {4, 2, 5, 5}, {5, 2, 5, 5}, {0, 3, 5, 5}, {1, 3, 5, 5}, {2, 3, 5, 5}, {3, 3, 5, 5}, {4, 3, 5, 5}, {5, 3, 5, 5}, {0, 4, 5, 5}, {1, 4, 5, 5}, {2, 4, 5, 5}, {3, 4, 5, 5}, {4, 4, 5, 5}, {5, 4, 5, 5}, {0, 5, 5, 5}, {1, 5, 5, 5}, {2, 5, 5, 5}, {3, 5, 5, 5}, {4, 5, 5, 5}, {5, 5, 5, 5}};
        public ArrayList<ArrayList<Integer>> narrow = new ArrayList<ArrayList<Integer>>();
        public static int[] lastG = {1,1,1,1};
        public static int[] pegs = {0,0,0,0};
    public makeGuess(){
        for (int i=0; i<all.length; i++){
            ArrayList<Integer> one = new ArrayList<Integer>();
            for (int j=0; j<4; j++){
                one.add(all[i][j]);
            }
            narrow.add(one);
        }
    }
    //true if it does not match the lastG the same number of times as pegs
    public boolean nomatch(ArrayList<Integer> checking, int[] lastG, int times){
        int matches =0;
        ArrayList<Integer> unmatched = new ArrayList<Integer>(4);
        for (int i: lastG)
            unmatched.add(i);
        for (int i=0; i<4; i++){
            for (int j=0; j<unmatched.size(); j++){
                if (checking.get(i) == unmatched.get(j)){
                matches+=1;
                unmatched.remove(j);
                break;
                }
            }
        }
        return (matches!=times);
    }
    //true if no perfect match                              
     public boolean noperfmatch(ArrayList<Integer> checking, int[] lastG, int perf){
        int matches =0;
         for (int i=0; i<4; i++){
            if (checking.get(i) == lastG[i]){
                matches+=1;
            }
        }
        return (matches!=perf);
    }
    /*
    this method first checks if the checking arrayList (which is a part of narrow) does not
    have the same number of matches with the lastGuess as the number of red pegs. If it
    does not, then nopermatch returns true, and the index is removed, because if it does not
    have the same matches with the lastGuess as red pegs, it cannot be the correct answer
    
    then, it checks if the checking arrayList (which is a part of narrow) does not have the
    same number of half matches (same number, different position) with the lastGuess as white
    pegs. If 
    */
    public int match(int index, ArrayList<Integer> checking, int[] lastG, int red, int white){
        int total = red +white;
        if (noperfmatch(checking, lastG, red)){
            narrow.remove(index);
            return 0; 
        }
         if (nomatch(checking, lastG, total)){
            narrow.remove(index);
            return 0; 
         }
        return 1;
    }
    public int check(int index, ArrayList<Integer> checking, int[] lastG, int[] pegs){
        //count the pegs of each type
        int red=0; 
        int white=0;
        for (int i=0; i<4; i++){
            if (pegs[i]==2){
                red+=1;
            }
            if (pegs[i]==1){
                white+=1;
            }
            else{
                break;
            }
        }
        return match(index, checking, lastG, red, white);
    }
    //go through every part of narrow and check it using pegs and the last guess
    public ArrayList guess(int[] lastG, int[] pegs){
        int i=1;
        while (i<narrow.size()){
            i+=check(i, narrow.get(i), lastG, pegs); //checks each part of narrow
        }
        return narrow.get(123);
    }
    public static void main(String[] args){
        makeGuess test = new makeGuess();
        System.out.println(test.guess(lastG, pegs));
    }
}

        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        