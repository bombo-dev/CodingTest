package programmers.lv2;

import java.util.*;

class Time {
    int hour;
    int minute;

    Time(int hour, int minute) {
        this.hour = hour;
        this.minute = minute;
    }

    public int convertTime() {
        return hour * 60 + minute;
    }
}

class MusicInfo implements Comparable<MusicInfo> {
    int index;
    Time startTime;
    Time endTime;
    String name;
    String muz;

    MusicInfo(int index, Time startTime, Time endTime, String name, String muz){
        this.index = index;
        this.startTime = startTime;
        this.endTime = endTime;
        this.name = name;
        this.muz = muz;
    }

    public int getSubstractTime() {
        return endTime.convertTime() - startTime.convertTime();
    }

    private String getMuz() {
        if(muz.length() <= getSubstractTime()) {
            int share = getSubstractTime() / muz.length();
            int remainder = getSubstractTime() % muz.length();
            String convert = "";
            if(remainder > 0) {
                convert = muz.repeat(share + 1);
            } else {
                convert = muz.repeat(share);
            }
            return convert;
        } else {
            return muz.substring(0, getSubstractTime());
        }
    }

    public boolean isFind(String m) {
        String convertMuz = getMuz();

        if(getMuz().contains(m))
            return true;

        return false;
    }

    public String toString() {
        return "차이 시간 : " + getSubstractTime() + ", 이름 : " + name + ", 음계 : " + muz;
    }

    @Override
    public int compareTo(MusicInfo m) {
        if(this.getSubstractTime() == m.getSubstractTime())
            return this.index - m.index;
        return m.getSubstractTime() - this.getSubstractTime();
    }
}
public class _17683 {
    static ArrayList<MusicInfo> list = new ArrayList<>();
    static ArrayList<MusicInfo> sameList = new ArrayList<>();
    static Map<String, String> map = new HashMap<>();
    public String solution(String m, String[] musicinfos) {
        init(musicinfos);
        classification(m);
        if(sameList.size() == 0) {
            return "(None)";
        }
        return sameList.get(0).name;
    }

    void init(String[] musicinfos) {
        settingMap();
        for(int i = 0; i < musicinfos.length; i++) {
            StringTokenizer st = new StringTokenizer(musicinfos[i],  ",");
            String startTime = st.nextToken();
            String endTime = st.nextToken();
            String name = st.nextToken();
            String muz = st.nextToken();
            muz = convertSharp(muz);

            MusicInfo musicinfo = new MusicInfo(
                    i,
                    stringToConvertTime(startTime),
                    stringToConvertTime(endTime),
                    name,
                    muz
            );

            list.add(musicinfo);
        }
    }

    void settingMap() {
        map.put("C#", "H");
        map.put("D#", "I");
        map.put("F#", "J");
        map.put("G#", "K");
        map.put("A#", "L");
    }

    String convertSharp(String muz) {
        for(String sharp : map.keySet()) {
            muz = muz.replaceAll(sharp, map.get(sharp));
        }
        return muz;
    }

    Time stringToConvertTime(String time) {
        String[] value = time.split(":");
        int hour = Integer.parseInt(value[0]);
        int minute = Integer.parseInt(value[1]);

        return new Time(hour, minute);
    }

    void classification(String m) {
        for(String sharp : map.keySet()) {
            m = m.replace(sharp, map.get(sharp));
        }

        for(MusicInfo info : list) {
            if(info.isFind(m)) {
                sameList.add(info);
            }
        }

        Collections.sort(sameList);
    }

    void print() {
        for(MusicInfo info : list) {
            System.out.println(info);
        }
    }
}
