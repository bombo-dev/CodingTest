package programmers.lv2;

import java.util.*;

class Node {
    int x;
    int y;

    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean checkValue(Node n) {
        if (this.x == n.x && this.y == n.y)
            return true;
        return false;
    }
}

class Position {
    Node from;
    Node to;

    Position(Node from, Node to) {
        this.from = from;
        this.to = to;
    }


    public boolean checkValue(Position p) {
        if (isForward(p) || isReverse(p))
            return true;
        return false;
    }

    private boolean isForward(Position p) {
        return this.from.checkValue(p.from) && this.to.checkValue(p.to);
    }

    private boolean isReverse(Position p) {
        return this.to.checkValue(p.from) && this.from.checkValue(p.to);
    }

    @Override
    public String toString() {
        return "[중복] 이전 노드 " + "[" + from.x + ", " + from.y + "], " + "이후 노드 " + "[" + to.x + ", " + to.y;
    }
}

public class _49994 {
    static ArrayList<Position> list = new ArrayList<>();
    static int result = 0;
    static Node node = new Node(0, 0);

    public int solution(String dirs) {

        for (int i = 0; i < dirs.length(); i++) {
            move(dirs.charAt(i));
        }


        return result;
    }

    public void move(char command) {
        Node preNode = new Node(node.x, node.y);
        switch (command) {
            case 'U':
                node.y += 1;
                if (node.y > 5) {
                    node.y -= 1;
                    return;
                }
                break;
            case 'R':
                node.x += 1;
                if (node.x > 5) {
                    node.x -= 1;
                    return;
                }
                break;
            case 'D':
                node.y -= 1;
                if (node.y < -5) {
                    node.y += 1;
                    return;
                }
                break;
            case 'L':
                node.x -= 1;
                if (node.x < -5) {
                    node.x += 1;
                    return;
                }
        }

        if (!check(preNode)) {
            result++;
        }

    }

    public boolean check(Node pre) {
        Position po = new Position(pre, new Node(node.x, node.y));
        boolean same = false;

        for (Position p : list) {
            if (po.checkValue(p)) {
                same = true;
                break;
            }
        }
        list.add(po);

        return same;
    }
}
