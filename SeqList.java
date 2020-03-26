package study;

public class SeqList {
    private int[] datas = new int[100];
    int size = 0;

    //打印顺序表
    public void display(){
        String s = "[";
        for(int i=0;i<size;i++){
            s +=datas[i];
            if(i!=size-1){
                s += ", ";
            }
        }
        s += "]";
        System.out.println("打印顺序表  >  "+s);
    }

    //在pos位置新增元素
    public void add(int pos, int data){
        if(size>=datas.length){
            int[] newDatas = new int[2*datas.length];
            for(int i=0;i<datas.length;i++){
                newDatas[i]=datas[i];
            }
            datas = newDatas;
        }
        if(pos<0&&pos>=size){
            System.out.println("下标错误");
        }else if(pos==size){
            datas[pos]=data;
            size++;
        }else{
            for(int i=size-1;i>=pos;i--){
                datas[i+1]=datas[i];
            }
            datas[pos]=data;
            size++;
        }
    }

    //查找某个元素对应的位置
    public int search(int toFind){
        for(int i=0;i<size;i++){
            if(datas[i]==toFind){
                return i;
            }
        }
        return -1;
    }

    //获取pos位置的元素
    public int getPos(int pos){
        return datas[pos];
    }

    //将pos位置的元素设置为value
    public void setPos(int pos, int value){
        datas[pos] =value;
    }

    //删除第一次出现的关键字key
    public void remove(int toRemove){
        int pos = search(toRemove);
        if(pos==-1){
            System.out.println("该元素不存在");
        }else if(pos ==size-1){
            size--;
        }else{
            for(int i=pos;i<size;i++){
                datas[i-1]=datas[i];
            }
            size--;
        }
    }

    //获取顺序表长度
    public int getSize(){
        return size;
    }

    //清空顺序表
    public void clear(){
        size=0;
    }

    public static void main(String[] args) {
        SeqList seq = new SeqList();
        seq.add(0,2);
        seq.add(0,4);
        seq.add(0,6);
        seq.add(0,8);
        seq.display();
        seq.remove(4);
        seq.remove(6);
        seq.display();
        seq.setPos(1,5);
        seq.setPos(1,6);
        seq.display();
        System.out.println(seq.getSize());
        System.out.println(seq.getPos(1));
        seq.remove(11);
        seq.clear();
        seq.display();
    }
}