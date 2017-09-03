package cn.yi.bank;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;


public class EventList {
	public static  int InterTime;//������һ�ͻ������ʱ����

	public static class Event{ 
    	public   int OccurTime;//can't be static!�¼�������ʱ�̣�����������뿪��,==�������е�ArrivalTime��
     	public  int NType;//�¼����ͣ�0��ʾ�ͻ��������¼�����1��4��ʾ�ĸ����ڵġ��뿪�¼���
        Event(int OccurT1,int NType1){//��������Ҫ�õ���
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
		//�ɲ����ڶ����ҵ���һ��
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