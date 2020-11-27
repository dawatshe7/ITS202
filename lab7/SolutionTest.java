public class SolutionTest{
	public static void main(String[] args) {
		
     
        Solution<String, Integer> obj = new Solution<String, Integer>();
        System.out.println(obj.isEmpty());
        //root = put(root,100);
        obj.put("Abdul", 1);
        System.out.println(obj.get("Abdul"));
        obj.put("Hrithik", 2);
        obj.put("Sai", 3);
        obj.put("Samal", 6);
        System.out.println(obj.get("Sai"));
        obj.put("Tashi", 4);
        System.out.println(obj.size());
        System.out.println(obj.min());
        System.out.println(obj.floor("Hrithik"));
        obj.put("Chimi", 5);
        obj.put("Samal", 4);
        System.out.println(obj.get("Samal"));
     
	}
}