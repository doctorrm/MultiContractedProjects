package cn.yi.bank;

import java.util.LinkedList;
import java.util.Queue;

public class Queues {
	public static int ArrivalTime;//每个客户到达的时刻。对应事件中的OccurTime.
	public static int ServeTime;//办理事务需要的时间
	//上面2个相加就得到客户的离开时刻。
	//string代表字符串'客户1'，'客户2'...
	public static Queue<String> getQueue(){
		Queue<String> queue=new LinkedList<String>();
		return queue;
	}
	
}
