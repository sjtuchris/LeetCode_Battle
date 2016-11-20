public List<Integer> closesetKValues(TreeNode root, double target, int k) {
	List<Integer> res = new ArrayList<>();

	Stack<Integer> s1 = new Stack<>();//predecessors
	Stack<Integer> s2 = new Stack<>();//successor

	inorder(root, target, false, s1);//left
	inorder(root, target, true, s2)//right

	while (k-- > 0){
		if (s1.isEmpty())
			res.add(s2.pop());
		else if (s2.isEmpty())
			res.add(s1.pop());
		else if (Math.abs(s1.peek()-target) < Math.abs(s2.peek()- target))
			res.add(s1.pop());
		else
			res.add(s2.pop());
	}
	return res;

}

void inorder(TreeNode root, double target, boolean reverse, Stack<Integer> stack){
	if (root == null) return;// the end of the traversal

	inorder(reverse ? root.right : root.left, target, reverse, stack);//false is left, if is left, we keep going left

	if ((reverse && root.val <=target) || (!reverse && root.val > target))
		return;//if false, it is the most left, and its val>target, all its root must> target, this means we have found where the target is, and this subtree's work is finished
	stack.push(root.val);// if false, from the very left to the root
	inorder(reverse ? root.left : root.right, target, reverse, stack);//if false, traversal the right subtree

}
