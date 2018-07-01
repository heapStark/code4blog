package heap.stark.algorithm;

import java.util.*;

/**
 * blogcode leetCode
 * Created by wangzhilei3 on 2018/1/25.
 */
public class Algorithm {
    class Point {
        int x;
        int y;


    }
    /**https://www.nowcoder.com/practice/6c9d8d2e426c4c58bbadfdf67d591696?tpId=85&tqId=29877&tPage=3&rp=3&ru=/ta/2017test&qru=/ta/2017test/question-ranking*/
    public static long findMOrderInN(long n,long m){
        if(m > n) return -1;
        long ans =1;
        while(m != 0){
            long cnt = getCount(ans,n);
            if(m > cnt){
                //下一个
                m -=  cnt;
                ans++;
                continue;
            }
            //在这层里面
            m--;
            if(m == 0) break;
            ans *= 10;

        }
        return  ans;
    }

    private static long getCount(long ans, long n) {
        long cnt=1;
        long p=10;
        for(;ans*p<=n;p*=10)
        {
            if(ans*p+p-1<n)
            {
                cnt+=p;
            }
            else {
                cnt+=(n-ans*p+1);
            }
        }
        return cnt;//计数
    }

    ArrayList<String> r = new ArrayList<String>();
    public ArrayList<String> generateParenthesis(int n) {
        gp("",0,0,n);
        return r;
    }
    private void gp(String s,int left,int right,int n){
        if(right==n){
            r.add(s);
        }
        if(left<n){
            gp(s+"(",left+1,right,n);
        }
        if(left>right){
            gp(s+")",left,right+1,n);
        }
    }
    //TODO
    public int lengthOfLongestUnReSubstring(String s) {
        char[] ch = s.toCharArray();
        int[] hash = new int[256];
        for(int i= 0 ; i<256 ;i++){
            hash[i] = -1;
        }
        int len = 0;
        int pre = -1; // i元素前面的最长非重复子串的长度
        int temp = -1;
        int end = -1;
        for(int i = 0 ; i<ch.length; i++){
            pre = Math.max(pre,hash[ch[i]]);
            len = Math.max(len,i - pre);
            hash[ch[i]] = i ;
        }
        return len;
    }


    public int lengthOfLongestSubstring(String s) {
        char[] ch = s.toCharArray();
        int[] hash = new int[256];
        for(int i= 0 ; i<256 ;i++){
            hash[i] = -1;
        }
        int len = 0;
        int pre = -1; // i元素前面的最长非重复子串的长度
        int temp = -1;
        int end = -1;
        for(int i = 0 ; i<ch.length; i++){
            pre = Math.max(pre,hash[ch[i]]);
            len = Math.max(len,i - pre);
            hash[ch[i]] = i ;
        }
        return len;
    }

    public String strStr(String s, String t)
    {
        if(s==null || t==null) return null;
        if(t.length() == 0) return s;

        if (s.indexOf(t)==-1){
            return null;
        }

        return s.substring(s.indexOf(t));
    }
    public String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] pos = new int[m + n];

        for(int i = m - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j, p2 = i + j + 1;
                int sum = mul + pos[p2];

                pos[p1] += sum / 10;
                pos[p2] = (sum) % 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int p : pos) if(!(sb.length() == 0 && p == 0)) sb.append(p);
        return sb.length() == 0 ? "0" : sb.toString();
    }

    public ArrayList<String> anagrams(String[] strs) {
        Map<String,ArrayList<String>> map = new HashMap<String,ArrayList<String>>();
        for(int i=0;i<strs.length;i++){
            char [] arr = strs[i].toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);
            if(!map.containsKey(key))
                map.put(key,new ArrayList<String>());
            map.get(key).add(strs[i]);
        }
        ArrayList<String> result = new ArrayList<String>();
        for(String key:map.keySet()){
            ArrayList<String> list = map.get(key);
            if(list.size()>1) result.addAll(list);
        }
        return result;
    }

    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        s = s.trim();
        int index = s.lastIndexOf(" ");

        return s.length() - index - 1;

    }

    public String addBinary(String a, String b) {
        int len1=a.length();
        int len2=b.length();


        char [] sum=new char[(len1>len2)?len1:len2];

        int i=len1-1;
        int j=len2-1;
        int k=sum.length-1;
        for(;i>=0&&j>=0;i--,j--,k--){

            sum[k]=(char)((a.charAt(i)-'0')+(b.charAt(j)-'0')+'0');

        }

        while(i>=0){
            sum[k--]=a.charAt(i--);
        }
        while(j>=0){
            sum[k--]=b.charAt(j--);
        }

        for(int l=sum.length-1;l>0;l--){

            int x=(sum[l]-'0')%2;
            int carry=(sum[l]-'0')/2;
            sum[l]=(char)(x+'0');
            sum[l-1]=(char)(sum[l-1]+carry);

        }
        if(sum[0]=='2'||sum[0]=='3'){
            char[] newa=new char[sum.length+1];
            System.arraycopy(sum,1,newa,2,sum.length-1);
            newa[1]=(char)((sum[0]-'0')%2+'0');
            newa[0]=(char)((sum[0]-'0')/2+'0');
            String str=new String(newa);
            return str;
        }

        return new String(sum);


    }

    public boolean isNumber(String s) {
        if(s.length()==0||s==null) return false;
        s=s.trim();
        boolean hasnum=false;
        boolean haspoint=false;
        boolean hase=false;
        boolean backe=false;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c>='0'&&c<='9'){
                hasnum=true;
                backe=true;
            }else if(c=='.'){
                if(haspoint||hase){
                    return false;
                }
                haspoint=true;
            }else if(c=='e'){
                if(hase||!hasnum){
                    return false;
                }
                hase=true;
                backe=false;
            }else if(c=='+'||c=='-'){
                if(i!=0&&s.charAt(i-1)!='e'){
                    return false;
                }
            }else{
                return false;
            }
        }
        return hasnum&&backe;
    }

    public String simplifyPath(String path) {
        Stack<String> s = new Stack<>();
        String[] p = path.split("/");
        for (String t : p) {
            if (!s.isEmpty() && t.equals("..")) {
                s.pop();
            } else if (!t.equals(".") && !t.equals("") && !t.equals("..")) {
                s.push(t);
            }
        }
        List<String> list = new ArrayList<>(s);
        return "/" + String.join("/", list);//jdk8新方法String.join()
    }

    public ArrayList<ArrayList<String>> partition(String s) {
        ArrayList<ArrayList<String>> result=new ArrayList<>();
        ArrayList<String> list=new ArrayList<>();
        addPalin(result,list,s);
        return result;
    }
    private void addPalin(ArrayList<ArrayList<String>> result,ArrayList<String> list,String s){
        if(s.length()==0){
            result.add(new ArrayList<String>(list));
            return;
        }
        for(int i=1;i<=s.length();++i){
            if(!isPali(s.substring(0,i))){
                continue;
            }
            list.add(s.substring(0,i));
            addPalin(result,list,s.substring(i));
            list.remove(list.size()-1);
        }

    }

    private boolean isPali(String str){
        int i=0;
        int j=str.length()-1;
        while(i<j){
            if(str.charAt(i)!=str.charAt(j))
                return false;
            ++i;
            --j;
        }
        return true;
    }

    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(num);
        for(int i=0;i<num.length;i++){
            if(i==0||num[i]>num[i-1]){
                int j=i+1;
                int k=num.length-1;
                while(j<k){
                    if(num[i]+num[j]+num[k]==0){
                        ArrayList<Integer> list = new ArrayList<Integer>();
                        list.add(num[i]);
                        list.add(num[j]);
                        list.add(num[k]);
                        result.add(list);
                        j++;
                        k--;
                        while(j<k&&num[j]==num[j-1]){
                            j++;
                        }
                        while(j<k&&num[k]==num[k+1]){
                            k--;
                        }
                    }else if(num[i]+num[j]+num[k]<0){
                        j++;
                    }else{
                        k--;
                    }
                }
            }
        }
        return result;
    }

    private void restoreIpAddresses(String s, ArrayList<String> result, ArrayList<String> ip, int start) {
        if (start == s.length() && ip.size() == 4) {
            result.add(ip.get(0) + "." + ip.get(1) + "." + ip.get(2) + "." + ip.get(3));
            return;
        }

        if (s.length() - start > 3 * (4 - ip.size())) return;
        if (s.length() - start < 4 - ip.size()) return;
        int num = 0;
        for (int i = start; i < start + 3 && i < s.length(); i++) {
            num = num * 10 + (s.charAt(i) - '0');
            if (num > 255) {
                break;
            }

            if (i > start && s.charAt(start) == '0') break;

            ip.add(s.substring(start, i + 1));
            restoreIpAddresses(s, result, ip, i + 1);
            ip.remove(ip.size() - 1);
        }
    }

    public ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> result = new ArrayList<>();
        ArrayList<String> ip = new ArrayList<>();
        if (s == null) return result;
        restoreIpAddresses(s, result, ip, 0);
        return result;
    }

    public void nextPermutation(int[] num) {

    }

    public int threeSumClosest(int[] num, int target) {
        //给定一个n个整数的数组S，在S中找到三个整数，使得总和最接近给定数量的目标。
        int len = num.length;
        int close = Integer.MAX_VALUE, result = 0;;
        for(int i = 0; i < len; i++){
            for(int j = i + 1; j < len; j++){
                for(int k = j + 1; k < len; k++){
                    int sum = num[i] + num[j] + num[k];
                    int error = Math.abs(sum - target );
                    if(error == 0)
                        return sum;
                    if(error < close){
                        close = error;
                        result = sum;
                    }
                }
            }
        }
        return result;
    }

    public int removeElement(int[] A, int elem) {
        int len=A.length;
        for(int i=0;i<len;i++)
        {
            if(A[i]==elem)
            {
                int tmp=A[len-1];
                A[len-1]=elem;
                A[i]=tmp;
                i--;
                len--;
            }
        }
        return len;
    }

    /**
     * how much water
     *
     * @param A
     * @return
     */
    //TODO
    public int trap(int[] A) {
        if(A.length<=2)
            return 0;
        int len = A.length;
        int leftMax = A[0],rigthMax = A[len-1];
        int i =1,j=len-2;
        int sum = 0;
        while(i<=j){
            //木桶理论，找右最大值
            if(leftMax>rigthMax){

                rigthMax = Math.max(rigthMax, A[j]);
                sum += rigthMax-A[j];
                j--;
            }else {
                sum += Math.max(0, leftMax-A[i]);
                leftMax = Math.max(leftMax, A[i]);
                i++;
            }
        }
        return sum;
    }

    public TreeNode buildTreePost(int[] inorder, int[] postorder) {
        if(inorder.length == 0 || postorder.length == 0)
            return null;
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        int i;
        for(i = 0;i < inorder.length;i ++){
            if(inorder[i] == postorder[postorder.length - 1]){
                break;
            }
        }
        if(i > 0)
            root.left = buildTree(Arrays.copyOfRange(inorder,0,i),Arrays.copyOfRange(postorder,0,i));
        root.right = buildTree(Arrays.copyOfRange(inorder,i + 1,inorder.length),Arrays.copyOfRange(postorder,i,postorder.length - 1));
        return root;
    }

    /**
     * 恢复二叉树
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0 || preorder.length != inorder.length){
            return null;
        }
        int rootVal = preorder[0];
        TreeNode root = new TreeNode(rootVal);

        int index = -1;
        for(int i = 0 ; i < inorder.length ; i++){
            if(rootVal == inorder[i]){
                index = i;
                break;
            }
        }

        root.left = buildTree(Arrays.copyOfRange(preorder,1,index+1),Arrays.copyOfRange(inorder,0,index));
        root.right = buildTree(Arrays.copyOfRange(preorder,index+1,preorder.length),Arrays.copyOfRange(inorder,index+1,inorder.length));
        return root;
    }

    /**
     * 除法计算
     * @param dividend
     * @param divisor
     * @return
     */
    public int divide(int dividend, int divisor) {
        int flag = 1;
        if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0))
            flag = -1;
        long ldividend = Math.abs((long) dividend);
        long ldivisor = Math.abs((long) divisor);
        if (ldividend == 0)
            return 0;
        if (ldivisor == 0)
            return flag == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        long res = solve(ldividend, ldivisor);
        int ans;
        if (res > Integer.MAX_VALUE) {
            ans = flag == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } else
            ans = (int) (res * flag);
        return ans;
    }

    public long solve(long ldividend, long ldivisor) {
        if (ldividend < ldivisor)
            return 0;
        long res = 1;
        long sum = ldivisor;
        while (sum + sum <= ldividend) {
            res += res;
            sum += sum;
        }
        return res + solve(ldividend - sum, ldivisor);
    }

    public int maxPoints(Point[] points) {
        if (points == null) {
            return 0;
        }
        int len = points.length;
        if (len <= 2) {
            return len;
        }
        int sum = 0;
        for (int i = 0; i < len; i++) {
            int n0 = 0; //表示点相同
            int n1 = 1; //表示在一条直线上
            for (int j = i + 1; j < len; j++) {
                if (points[i].x == points[j].x && points[i].y == points[j].y) {
                    n0++;
                } else {
                    n1++;
                    int x1 = points[i].x - points[j].x;
                    int y1 = points[i].y - points[j].y;
                    for (int m = j + 1; m < len; m++) {
                        int x2 = points[m].x - points[j].x;
                        int y2 = points[m].y - points[j].y;
                        if (x1 * y2 == x2 * y1) {
                            n1++;
                        }
                    }
                }
                if (sum < (n0 + n1)) {
                    sum = n0 + n1;
                }
                n1 = 1;
            }
        }
        return sum;
    }

    /**
     * 从两头扫描
     *
     * @param ratings
     * @return
     */
    public int candy(int[] ratings) {
        int[] score = new int[ratings.length];
        score[0] = 1;
        for (int a = 1; a < ratings.length; a++) {
            if (ratings[a] == ratings[a - 1]) {
                score[a] = 1;
            } else if (ratings[a] > ratings[a - 1]) {
                score[a] = score[a - 1] + 1;
            } else if (ratings[a] < ratings[a - 1]) {
                score[a] = 1;
                if (score[a - 1] == 1) {
                    score[a - 1] = 2;
                    for (int i = a - 1; i > 0; i--) {
                        if (ratings[i - 1] > ratings[i] && score[i - 1] < score[i]) {
                            score[i - 1] = 1 + score[i];
                        }
                    }
                }
            }
        }
        int k = 0;
        for (int a = 0; a < ratings.length; a++) {
            k = k + score[a];
        }
        return k;
    }

    /**
     * 两头扫描，rate相等对大小没有要求
     *
     * @param ratings
     * @return
     */
    public int candy2(int[] ratings) {
        int n = ratings.length;
        if (n == 0 || ratings == null)
            return 0;
        int[] count = new int[n];
        int sum = 0;
        //初始，每个孩子至少有一颗糖
        Arrays.fill(count, 1);
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                count[i] = count[i - 1] + 1;
            }
        }
        for (int i = n - 1; i > 0; i--) {
            if (ratings[i] < ratings[i - 1] && count[i] >= count[i - 1]) {
                count[i - 1] = count[i] + 1;
            }
            sum += count[i];
        }
        sum += count[0];
        return sum;

    }

    /**
     * 回文字符串
     *
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            while (!isLetterOrNumber(s.charAt(i)) && i < j)
                i++;
            while (!isLetterOrNumber(s.charAt(j)) && i < j)
                j--;
            if (i < j && Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) return false;
            i++;
            j--;
        }
        return true;
    }

    public static boolean isLetterOrNumber(char i) {
        if (i >= '0' && i <= '9' || i >= 'a' && i <= 'z' || i >= 'A' && i <= 'Z') return true;
        return false;
    }

    /**
     * 链表排序
     *
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {

        if (head == null || head.next == null)
            return head;
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode right = sortList(slow.next);
        slow.next = null;
        ListNode left = sortList(head);
        return mergeSorted(left, right);

    }

    /**
     * mergeSorted
     *
     * @param left
     * @param right
     * @return
     */
    public ListNode mergeSorted(ListNode left, ListNode right) {

        ListNode temp_head = new ListNode(0);
        ListNode temp_node = temp_head;
        while (left != null && right != null) {
            if (left.val < right.val) {
                temp_node.next = left;
                left = left.next;
            } else {
                temp_node.next = right;
                right = right.next;
            }
            temp_node = temp_node.next;
        }
        if (left != null)
            temp_node.next = left;
        if (right != null)
            temp_node.next = right;
        return temp_head.next;
    }

    /**
     * 递归解法效率很差
     *
     * @param head
     * @return
     */
    public ListNode reorderListHelper(ListNode head) {

        return head;
    }

    /**
     * 快慢指针拆分
     *
     * @param head
     */
    public void reorderList(ListNode head) {
        if (head == null || head.next == null)
            return;
        ListNode after = reverseList(twoList(head));

        // 合并两个链表
        ListNode first = head;
        while (first != null && after != null) {
            ListNode ftemp = first.next;
            ListNode aftemp = after.next;
            first.next = after;
            first = ftemp;
            after.next = first;
            after = aftemp;
        }
    }

    /**
     * 链表拆分
     *
     * @param head
     * @return
     */
    public ListNode twoList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        // 快满指针找到中间节点
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // 拆分链表
        ListNode temp = slow.next;
        slow.next = null;
        return temp;
    }

    /**
     * 链表逆序
     *
     * @param head
     */
    public ListNode reverseList(ListNode head) {
        ListNode tail = head;
        head = null;
        while (tail != null) {
            ListNode temp = tail.next;
            tail.next = head;
            head = tail;
            tail = temp;
        }
        return head;
    }

    /**
     * 合并链表
     *
     * @param listNode1
     * @param listNode2
     * @return
     */
    public ListNode merge(ListNode listNode1, ListNode listNode2) {
        ListNode tail = new ListNode(1);
        ListNode listNode = tail;
        while (listNode1 != null && listNode2 != null) {
            tail.next = listNode1;
            tail.next.next = listNode2;
            tail = listNode2;
            listNode2.next = listNode1.next;
            listNode1 = listNode1.next;
            listNode2 = listNode2.next;
        }
        return listNode.next;
    }

    /**
     * 有环快慢指针碰撞
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode fast = head;
        ListNode low = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            low = low.next;
            if (fast == low) {
                return true;
            }

        }
        return false;
    }

    /**
     * 环的位置
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                ListNode slow2 = head;
                while (slow2 != slow) {
                    slow = slow.next;
                    slow2 = slow2.next;
                }
                return slow;
            }
        }
        return null;
    }

    /**
     * 合并有K个序数组
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if (null == lists || lists.size() <= 0)
            return null;
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.size(), new Comp());
        for (ListNode head : lists) {
            if (null != head)
                queue.offer(head);
        }
        ListNode dummy = new ListNode(0);
        ListNode pnode = dummy;
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            pnode.next = node;
            if (node.next != null)
                queue.offer(node.next);
            pnode = pnode.next;

        }
        return dummy.next;

    }

    /**
     * swapPairs pre, cur, temp 三组变量
     *
     * @param head
     * @return
     */
    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        for (ListNode pre = dummy, cur = head, temp; cur != null && cur.next != null; pre = cur, cur = cur.next) {
            temp = cur.next;
            cur.next = temp.next;
            temp.next = pre.next;
            pre.next = temp;
        }
        return dummy.next;
    }

    /**
     * 倒数k个前置
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null)
            return head;
        ListNode preHead = new ListNode(0);
        preHead.next = head;
        ListNode cur = head;
        ListNode pre = head;
        int total;
        for (total = 1; cur.next != null; total++)
            cur = cur.next;
        for (int i = 1; i < total - k % total; i++) {
            pre = pre.next;
        }
        cur.next = preHead.next;
        preHead.next = pre.next;
        pre.next = null;

        return preHead.next;
    }

    /**
     * 链表去重
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {

        ListNode cur = head;
        while (cur != null) {
            while (cur.next != null && cur.val == cur.next.val) {
                cur.next = cur.next.next;
            }
            cur = cur.next;
        }
        return head;
    }

    /**
     * @param head
     * @return
     */
    public ListNode deleteAllDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode newHead = new ListNode(head.val - 1);
        newHead.next = head;
        ListNode cur = head;
        ListNode pre = newHead;
        while (cur != null && cur.next != null) {
            if (cur.val != cur.next.val) {
                pre = cur;
            } else {
                while (cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;
                }
                pre.next = cur.next;
            }
            cur = cur.next;
        }
        return newHead.next;
    }

    /**
     * sortedListToBST
     *
     * @param head
     * @return
     */
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return new TreeNode(head.val);
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode root = new TreeNode(slow.next.val);
        root.right = sortedListToBST(slow.next.next);
        slow.next = null;
        root.left = sortedListToBST(head);
        return root;
    }

    /**
     * 1) begin开始指向0， end一直后移，直到begin - end区间包含T中所有字符。
     * 记录窗口长度d
     * 2) 然后begin开始后移移除元素，直到移除的字符是T中的字符则停止，此时T中有一个字符没被
     * 包含在窗口，
     * 3) 继续后移end，直到T中的所有字符被包含在窗口，重新记录最小的窗口d。
     * 4) 如此循环知道end到S中的最后一个字符。
     * 时间复杂度为O(n)
     *
     * @param S
     * @param T
     * @return
     */
    public String minWindow(String S, String T) {
        int[] map = new int[128];
        //init map, 记录T中每个元素出现的次数
        for (int i = 0; i < T.length(); i++) {
            map[T.charAt(i)]++;
        }
        // begin end两个指针指向窗口的首位，d记录窗口的长度， counter记录T中还有几个字符没被窗口包含
        int begin = 0, end = 0, d = Integer.MAX_VALUE, counter = T.length(), head = 0;
        // end指针一直向后遍历
        while (end < S.length()) {
            // map[] > 0 说明该字符在T中出现，counter-- 表示对应的字符被包含在了窗口，counter--, 如果s中的字符没有在T中出现，则map[]中对应的字符-1后变为负值
            if (map[S.charAt(end++)]-- > 0) {
                counter--;
            }
            // 当counter==0时，说明窗口已经包含了T中的所有字符
            while (counter == 0) {
                if (end - begin < d) {
                    d = end - (head = begin);
                }
                if (map[S.charAt(begin++)]++ == 0) {  // begin开始后移，继续向后寻找。如果begin后移后指向的字符在map中==0，表示是在T中出现的，如果没有出现，map[]中的值会是负值。
                    counter++;                      // 在T中的某个字符从窗口中移除，所以counter++。
                }
            }
        }
        return d == Integer.MAX_VALUE ? "" : S.substring(head, head + d);
    }


    /**
     * 链表求和
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode re = new ListNode((l1.val + l2.val) % 10);
        re.next = addTwoNumbers(l1.next, l2.next, (l1.val + l2.val) / 10);
        return re;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2, int x) {
        if (l1 == null && l2 == null && x == 0) {
            return null;
        }
        if (l1 == null) {
            return addTwoNumbers(l2, new ListNode(x));
        }
        if (l2 == null) {
            return addTwoNumbers(l1, new ListNode(x));
        }
        ListNode re = new ListNode((l1.val + l2.val + x) % 10);
        re.next = addTwoNumbers(l1.next, l2.next, (l1.val + l2.val + x) / 10);
        return re;
    }


    public void sortedListToBSTTest() {
        ListNode listNode = new ListNode(3);
        listNode.next = new ListNode(5);
        //listNode.next.next = new ListNode(8);
        TreeNode treeNode = sortedListToBST(listNode);
        System.out.print("");
    }


    /**
     * 快排
     *
     * @param array
     * @param startIndex
     * @param endIndex
     */
    private void sortCore(int[] array, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }

        int boundary = boundary(array, startIndex, endIndex);
        sortCore(array, startIndex, boundary - 1);
        sortCore(array, boundary + 1, endIndex);
    }

    /**
     * @param array
     * @param startIndex
     * @param endIndex
     * @return
     */
    private int boundary(int[] array, int startIndex, int endIndex) {
        int standard = array[startIndex]; // 定义标准
        int leftIndex = startIndex; // 左指针
        int rightIndex = endIndex; // 右指针

        while (leftIndex < rightIndex) {
            while (leftIndex < rightIndex && array[rightIndex] >= standard) {
                rightIndex--;
            }
            array[leftIndex] = array[rightIndex];

            while (leftIndex < rightIndex && array[leftIndex] <= standard) {
                leftIndex++;
            }
            array[rightIndex] = array[leftIndex];
        }

        array[leftIndex] = standard;
        return leftIndex;
    }

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return root.val;
        } else {
            int k = Math.max(root.val + maxPathSum(root.left), root.val + maxPathSum(root.right));
            k = Math.max(k, root.val);
            if (k > 0) {
                return k;
            } else return 0;
        }
    }

    public int longestValidParenthesesDP(String s) {
        if (s.length() == 0 || s.equals("")) {
            return 0;
        }
        char[] st = s.toCharArray();
        int[] dp = new int[st.length];
        int pre = 0;
        int res = 0;
        for (int i = 1; i < st.length; i++) {
            if (st[i] == ')') {
                pre = i - dp[i - 1] - 1;
                if (pre >= 0 && st[pre] == '(') {
                    dp[i] = dp[i - 1] + 2 + (pre > 0 ? dp[pre - 1] : 0);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public int longestValidParenthesesS(String s) {
        if (s == null || s.length() < 1)
            return 0;
        Stack<Integer> stack = new Stack<Integer>();
        int max = 0, left = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                stack.push(i);
            else {
                if (!stack.isEmpty()) {
                    stack.pop();
                    if (!stack.isEmpty())
                        max = Math.max(max, i - stack.peek());
                    else
                        max = Math.max(max, i - left);
                } else
                    left = i;
            }
        }
        return max;
    }

    public boolean hasPathSum(TreeNode root, int target) {
        if (root == null) return false;

        if (root.val == target && root.left == null && root.right == null) return true;
        return hasPathSum(root.left, target - root.val)
                || hasPathSum(root.right, target - root.val);
    }

    ArrayList<ArrayList<Integer>> lists = new ArrayList<>();

    public void hasPathSumHelp(TreeNode root, int target, ArrayList<Integer> list) {
        if (root == null) return;
        list.add(root.val);
        if (root.val == target && root.left == null && root.right == null) {
            lists.add(list);
            return;
        } else {
            hasPathSumHelp(root.right, target - root.val, list);
            hasPathSumHelp(root.left, target - root.val, new ArrayList<>(list));
        }

    }

    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        hasPathSumHelp(root, sum, new ArrayList<>());
        return lists;
    }


    ArrayList<ArrayList<Integer>> res = null;

    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        res = new ArrayList<ArrayList<Integer>>();
        if (root == null)
            return res;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        levelOrderBottom(queue);
        return res;
    }

    private void levelOrderBottom(Queue<TreeNode> queue) {
        if (queue.isEmpty())
            return;
        int size = queue.size();
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < size; i++) {
            TreeNode node = queue.poll();
            if (node.left != null)
                queue.offer(node.left);
            if (node.right != null)
                queue.offer(node.right);
            list.add(node.val);
        }
        // 理解堆栈的原理，先进行递归，再将list保存到res中
        levelOrderBottom(queue);
        res.add(list);
    }

    /**
     * 本体解法基于84. Largest Rectangle in Histogram
     * 把每一行看成求直方图中最大矩形面积问题
     */
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;
        int m = matrix.length, n = matrix[0].length;
        int max = 0;
        int[] h = new int[n];
        for (int i = 0; i < m; i++) {
            Stack<Integer> stack = new Stack<Integer>();
            stack.push(-1);
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1')
                    h[j] += 1;
                else
                    h[j] = 0;

            }
            for (int j = 0; j < n; j++) {
                while (stack.peek() != -1 && h[j] < h[stack.peek()]) {
                    int top = stack.pop();
                    max = Math.max(max, (j - 1 - stack.peek()) * h[top]);
                }
                stack.push(j);
            }
            while (stack.peek() != -1) {
                int top = stack.pop();
                max = Math.max(max, (n - 1 - stack.peek()) * h[top]);
            }
        }
        return max;
    }


    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (root == null) return res;
        inorder(root, res);
        return res;
    }

    private static void inorder(TreeNode root, ArrayList<Integer> list) {
        if (root != null) {
            inorder(root.left, list);
            list.add(root.val);
            inorder(root.right, list);
        }
    }

    public int maxProfit(int[] prices) {
        int buy1 = Integer.MIN_VALUE, sell1 = 0, buy2 = Integer.MIN_VALUE, sell2 = 0;
        for (int i = 0; i < prices.length; i++) {
            buy1 = Math.max(buy1, -prices[i]);   //记录之前所有天最便宜的股价
            sell1 = Math.max(sell1, buy1 + prices[i]);  //记录之前所有天只进行1次买卖的最大利益
            buy2 = Math.max(buy2, sell1 - prices[i]);   //记录之前天先进行1次交易获得最大利益后，
            //再买到那次交易后最便宜股价时剩余的净利润
            sell2 = Math.max(sell2, buy2 + prices[i]); //记录之前天进行2次完整交易的最大利润
        }
        return sell2;

    }

    public ArrayList<TreeNode> generateTrees(int n) {

        return generateTrees(1, n);
    }

    public ArrayList<TreeNode> generateTrees(int n, int m) {
        if (n < 1) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = n; i <= m; i++) {
            TreeNode treeNode = new TreeNode(i);
            ArrayList arrayList1 = generateTrees(n, i - 1);
            ArrayList arrayList2 = generateTrees(i + 1, m);

        }

        return arrayList;
    }

    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        if (intervals == null || intervals.size() == 0) {
            return new ArrayList<>(Arrays.asList(newInterval));
        }
        for (Interval interval : intervals) {
            if (interval.end < newInterval.start) {

            } else if (interval.end >= newInterval.start) {
                interval.end = Math.max(interval.end, newInterval.start);
            }
        }


        return null;
    }
}


class Comp implements Comparator<ListNode> {
    public int compare(ListNode o1, ListNode o2) {
        return o1.val - o2.val;
    }
}

class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}
