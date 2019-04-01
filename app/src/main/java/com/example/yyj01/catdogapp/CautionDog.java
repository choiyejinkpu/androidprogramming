package com.example.yyj01.catdogapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;

public class CautionDog extends AppCompatActivity {
    ExpandableListView listMain;

    private ArrayList<String > arrayGroup=new ArrayList<String>();
    private HashMap<String,ArrayList<String>> arrayChild=new HashMap<String, ArrayList<String>>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caution_dog);

        listMain = (ExpandableListView) this.findViewById(R.id.exlist);
        setArrayData();
        listMain.setAdapter(new AdptMain(this, arrayGroup, arrayChild));
    }

    private void setArrayData(){
        for(int i=0;i<7;i++){
            arrayGroup.add(list_menu[i].toString());
        }
        ArrayList<String> array_text1=new ArrayList<String>();
        array_text1.add(list_text[0].toString());

        ArrayList<String> array_text2=new ArrayList<String>();
        array_text2.add(list_text[1].toString());

        ArrayList<String> array_text3=new ArrayList<String>();
        array_text3.add(list_text[2].toString());

        ArrayList<String> array_text4=new ArrayList<String>();
        array_text4.add(list_text[3].toString());

        ArrayList<String> array_text5=new ArrayList<String>();
        array_text5.add(list_text[4].toString());

        ArrayList<String> array_text6=new ArrayList<String>();
        array_text6.add(list_text[5].toString());

        ArrayList<String> array_text7=new ArrayList<String>();
        array_text7.add(list_text[6].toString());

        arrayChild.put(arrayGroup.get(0),array_text1); arrayChild.put(arrayGroup.get(4),array_text5);
        arrayChild.put(arrayGroup.get(1),array_text2); arrayChild.put(arrayGroup.get(5),array_text6);
        arrayChild.put(arrayGroup.get(2),array_text3); arrayChild.put(arrayGroup.get(6),array_text7);
        arrayChild.put(arrayGroup.get(3),array_text4);
    }

    static final String[] list_menu={
            "먹지 말아야할 음식",
            "간식 종류와 특징",
            "항문낭 관리하기",
            "양치 하기",
            "귀청소 하기",
            "발톱 손질하기",
            "눈 관리하기",
    };

    static final String[] list_text={
            " \uD83D\uDEAB 중독 증상을 보이는 음식\n\n양파, 대파, 마늘, 초콜릿, 커피, 자일리톨, 포도, 건포도, 마카다미아, 술, 아보카도 등 \n\n" +
                    " \uD83D\uDEAB 소화관을 다치게 하는 음식\n\n닭뼈, 생선뼈, 아몬드, 자두씨/감씨 등 과일의 씨앗, 옥수수 대 등 \n\n" +
                    " \uD83D\uDEAB 소화가 힘든 음식\n\n과자, 빵, 우유, 유제품 등 \n\n" +
                    " \uD83D\uDEAB 질병을 유발하는 음식\n\n삼겹살, 돼지 비계 등 기름진 음식, 날계란, 날고기, 간이 된 음식 등",
            "✔ 껌 \n\n\t보통 소가죽으로 만들어진 껌은 반려견 크기를 고려하여 적당한 크기의 개껌을 주면 몇날 몇일이 걸려요! \n \t껌은 씹는행동을 계속할 수 있게 해, 반려견이 스트레스를 푸는 데 도움을 줘요! \n\n" +
                    "✔ 져키\n\n 소,돼지,닭고기 등을 건조시켜서 만든 가공식품을 져키라고 해요\n 져키 중 촉촉한 느낌을 주기위해 첨가물을 이용하는 것이 있는데,이 첨가물이 체중을 증가시킬 수 있으므로 그런 경우에는 하루제공량을 잘 조절해 주어야 해요!\n\n" +
                    "✔ 쿠키,비스킷 \n\n 곡류 반죽으로 구워낸 강아지 전용 쿠키와 비스킷은 반려견의 선호도가 좋은 편이에요!\n 하지만 잉여 탄수화물을 섭취하는 것이므로 체중을 증가시킬 수 있어요.\n  ",
            "\uD83D\uDC9C항문낭을 주기적으로 관리하지 않으면, 항문낭염을 일으키고, 심한 경우 항문낭이 파열되기도 해요.항문낭 액은 고약한 냄새를 풍기므로, 목욕직전에 항문낭을 짜는 것이 좋아요\n\n"+
                    "⭐TIP!\n \t짜는 방법을 잘 모르겠다면, 동물병원에 내원했을 때 동물병원의 스탭에게 설명을 요청해 보세요!",
            "\uD83D\uDC9C양치는 치주질환을 예방하기 위한 필수 관리지만, 대부분의 반려견이 거부감을 보아므로 반려견인의 인내심이 필요하니,시간을 가지고 단계별로 시도해 보세요\n\n" +
                    "\t거부감이 심하다면, 일반 반려견용 칫솔이 아닌 실리콘 손가락 칫솔이나 거즈를 이용하는 것도 방법이에요\n" +
                    "\t성견이 되었다고 양치교육의 효과가 전혀 없는 것은 아니지만, 어릴 때부터 양치교육을 하는 것이 더 익숙하게 하는 게 쉽기 때문에 아직 유치만 있는 시기라도 빨리 시작하는 것을 추천해요\n",
            "\uD83D\uDC9C반려견의 귀는 사림의 귀와 달리, 이도가'ㄴ'자로 꺾여 있어요.\n \t그렇기 때문에 안쪽까지 닦을 수 없으므로, 귀 전용 세정제를 이용해 귀 안쪽까지 청결하게 관리해 주세요!\n\n"+
                    "⭐TIP!\n\t 면봉은 반려견의 귀에 상처를 입힐 수 있고 드물게 면봉의 솜이 빠져 귓속에 남아있게 되는 경우도 있으므로 이용하지 않는 것이 좋아요\n",
            "\uD83D\uDC9C실외에서 생활하는 반려견의 경우, 발톱이 자연스럽게 닳아서 짧아지지만, 실내에서 생활하는 반려견의 경우에는 주기적으로 발톱을 깎아 줘야해요\n\n"+
                    "\uD83D\uDC8E발톱관리를 해주지 않으면, 길어진 발톱이 발바닥을 파고들이도 하므로 주의해주세요!\n"
                    +"\t발톱을 깎는데 저항이 너무 심하다면, 놀이와 간식을 이용해서 발톱 깎는 시간이 즐겁게 느껴질 수 있도록 하고, 평소에도 다리와 발을 자주 만져주면서 차츰 거부감을 없애주세요!\n\n"
                    +"⭐적당한횟수\n\t목욕할 때마다 발톱 길이를 점검하고, 너무 길다는 느낌이 들면 깎아주세요!\n",
            "\uD83D\uDC9C자고일어나면 자연스럽게 눈곱이 낄 수 있는데, 이 경우 반려견이 발로 문질러서 떼어낼 때도 있지만 그렇지 못 할 경우 반려견인의 도움이 필요해요\n\n"+
                    "\t눈곱이 마른 상태에서 떼려고 하면 통증을 유발할 수 있으므로 물에 젖은 거즈나 눈곱빗 등을 이용해서 살살 떼어내 주세요!\n"
    };

}
