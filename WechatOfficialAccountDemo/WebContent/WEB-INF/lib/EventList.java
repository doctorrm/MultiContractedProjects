package cn.yi.bank;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;


public class EventList {
	public static  int InterTime;//距离下一客户到达的时间间隔

	public static class Event{ 
    	public   int OccurTime;//can't be static!事件发生的时刻（包括到达和离开）,==队列类中的ArrivalTime。
     	public  int NType;//事件类型，0表示客户‘到达事件’，1到4表示四个窗口的‘离开事件’
        Event(int OccurT1,int NType1){//程序真正要用到的
        	this.OccurTime=OccurT1;
        	this.NType=NType1;					
         }
		@Override
		public String toString() {
			return "Event [OccurTime=" + OccurTime + ", NType=" + NType + "]";
		}     
    }
	
	class MyTimeComp implements Comparator<Event>{
		 
	    @Override
	    public int compare(Event e1, Event e2) {
	        if(e1.OccurTime < e2.OccurTime){
	            return -1;
	        } else {
	            return 1;
	        }
	    }
	}
	
	public int findTimeByType(int Type,LinkedList<Event> ll){
		//由参数第二个找到第一个
		Iterator<Event> iterator=ll.iterator();
		while(iterator.hasNext()){
			Event event=iterator.next();
			if(event.NType==Type){
//				System.out.println(event.NType);
				return event.OccurTime;
			}
		}return -111;
	}
	public int findTypeByTime(int Time,LinkedList<Event> ll){
		Iterator<Event> iterator=ll.iterator();
		while(iterator.hasNext()){
			Event event=iterator.next();
			if(event.OccurTime==Time){
				return event.NType;
			}			
		}return -1;
	}
	public void sortEvent(LinkedList<Event> ll){
		Collections.sort(ll,new MyTimeComp());
		
	}
	public void insertByTime(Event e,LinkedList<Event> ll){
		ll.add(e);
		sortEvent(ll);
	}
	
	public void deleteByTime(int OccurT,LinkedList<Event> ll){
		Iterator<Event> iterator=ll.iterator();
		while(iterator.hasNext()){
			Event e=iterator.next();
			if(e.OccurTime==OccurT)
				ll.remove(e);
		}
	}
	public static void main(String[] args){
		LinkedList<Event> ll=new LinkedList<Event>();
		EventList test=new EventList();
		test.insertByTime(new Event(44,4), ll);
		test.insertByTime(new Event(22,2), ll);
		test.insertByTime(new Event(33,3), ll);
		
		for(Event e:ll){
			System.out.println(e);
		}
		test.deleteByTime(44, ll);
		for(Event e:ll){
			System.out.println(e);
		}
	
	}

}