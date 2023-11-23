package Trees;

import java.util.ArrayList;
import java.util.List;

public class NAryTree<T> {
    NaryNode root;


    public void insert(T value) {
        NaryNode newNode = new NaryNode(value);

        
    }

    class NaryNode {
        List<NaryNode> children = new ArrayList<>();
        T value;

        public NaryNode(T value) {
            this.value = value;
        }

        public boolean addChild(NaryNode child) {
            if (children.contains(child)) {
                return false;
            } else {
                children.add(child);
                return true;
            }
        }
    }
}
