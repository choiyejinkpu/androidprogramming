package com.example.yyj01.catdogapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;

public class Caution extends AppCompatActivity {
    ExpandableListView listMain;

    private ArrayList<String > arrayGroup=new ArrayList<String>();
    private HashMap<String,ArrayList<String>> arrayChild=new HashMap<String, ArrayList<String>>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caution);

        listMain = (ExpandableListView) this.findViewById(R.id.exlist);
        setArrayData();
        listMain.setAdapter(new AdptMain(this, arrayGroup, arrayChild));
    }

    private void setArrayData(){
        for(int i=0;i<8;i++){
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

        ArrayList<String> array_text8=new ArrayList<String>();
        array_text8.add(list_text[7].toString());

        arrayChild.put(arrayGroup.get(0),array_text1); arrayChild.put(arrayGroup.get(4),array_text5);
        arrayChild.put(arrayGroup.get(1),array_text2); arrayChild.put(arrayGroup.get(5),array_text6);
        arrayChild.put(arrayGroup.get(2),array_text3); arrayChild.put(arrayGroup.get(6),array_text7);
        arrayChild.put(arrayGroup.get(3),array_text4); arrayChild.put(arrayGroup.get(7),array_text8);
    }

    static final String[] list_menu={
            "먹지 말아야할 음식",
            "사료 종류와 특징",
            "비만도 체크",
            "양치 하기",
            "귀청소 하기",
            "발톱 손질하기",
            "눈 관리하기",
            "항문낭 관리하기"
    };

    static final String[] list_text={
            " \uD83D\uDEAB중독 증상을 보이는 음식\n\n양파, 대파, 마늘 혹은 해당 재료로 만든 음식, 초콜릿, 커피, 술\n\n" +
                    " \uD83D\uDEAB소화관을 다치게 하는 음식\n\n닭뼈, 생선뼈, 아몬드류, 과일의 씨앗\n\n" +
                    " \uD83D\uDEAB소화가 힘든 음식\n\n과자, 빵, 우유, 유제품 등\n\n" +
                    " \uD83D\uDEAB질병을 유발하는 음식\n\n기름진 음식, 날계란, 날고기, 간이 된 음식 등",
            " ✔건사료\n\n브랜드별로 영양 배합이 조금씩 다를 수는 있지만, 건사료는 가장 일반적인 형태의 사료로 필수적인 영향 균형이 맞춰져 있어요~!\n\n" +
                    "종류에 따라 알갱이의 크기와 모양이 다르기도 해요. 건사료는 수분 함유율이 적기 때문에, 신선한 물을 제공하여 반려묘가 물을 많이 마실 수 있도록 해 주세요\n\n" +
                    " ✔습식사료\n\n수분 함유량이 굉장히 높은 사료로 주로 캔 형태로 되어 있어요~\n건사료, 반건조사료, 습식사료 중 기호성은 가장 높고, 가격도 가장 비싸요. 구성 함량에 따라 주식캔과 간식캔으로 나뉘므로, 구입 시 주식캔인지 꼭 확인해 주세요!",
            " ✔마른 몸\n\n단모종 고양이를 기준으로, 육안으로도 갈비뼈와 골반뼈가 확연히 드러나고, 허리가 쏙 들어가 있으며, 말랑말랑한 지방이 거의 만져지지 않는다면 마른 체형이에요\uD83D\uDE3A\n\n" +
                    " ✔이상적인 몸\n\n육안으로 봤을 때, 갈비뼈가 약간 드러나 보이지만 말랑말랑한 지방이 적당히 만저지고, 허리는 잘록하며 옆에서 봤을 때 배가 살짝 들어가 있다면, 이상적인 체형이에요\uD83D\uDE3B\n\n" +
                    " ✔비만\n\n지방에 덮혀 갈비뼈가 육안으로 보이지 않으며, 가슴 부분에 손을 얹었을 때 뼈 대신 살이 만져지고 허리와 배가 살로 뎦혀있어 쏙 들어간 부분이 없다면, 뚱뚱한 체형이에요\uD83D\uDE39",
            " \uD83D\uDC9C양치는 치주질환을 예방하기 위한 필수 관리지만, 대부분의 반려묘가 거부감을 보이므로 반려인의 인내심이 필요하니, 시간을 가지고 단계별로 시도해 보세요\uD83D\uDE00\n거부감이 심하다면, 실리콘 손가락 칫솔이나 거즈를 이용하는 것도 좋은 방법이에요~!\n\n" +
                    "① 반려동물 전용 치약을 손가락에 짜서 치약의 맛을 볼 수 있게 해 주세요.\n\n" +
                    "② 거부감을 보이지 않는다면, 치약을 잇몸에 발라 보세요. 앞니의 잇몸에 발랐을 때, 거부감이 없다면 입을 벌리면서 점차 어금니 쪽으로 옮겨 가며 발라 보세요\n\n" +
                    "③ 아직까지 괜찮다면, 칫솔에 도전해 보세요. 치약을 바른 칫솔을 앞니에 살짝 댔다가 떼는 과정을 짧게 반복하면서 점차 시간을 늘려보세요~!\n\n" +
                    "④ 앞니에 칫솔을 대는 것을 싫어하지 않는다면, 입을 벌리면서 어금니 쪽에 칫솔을 대 보세요.\n\n" +
                    "⑤ 여기까지 성공했다면, 솔질을 시도해 보세요\uD83D\uDE3C",
            " \uD83D\uDC9C고양이의 귀는 사람의 귀와 달리, 이도가 'ㄴ'자로 꺾여 있어요. 그렇기때문에 안쪽까지 닦을 수 없으므로, 귀 전용 세정제를 이용해 귀 안쪽까지 청결하게 관리해 주세요\uD83D\uDE00\n\n" +
                    "① 고양이의 고개를 살짝 갸웃 기울인 상태로 귓속에 귀 전용 세정제를 부어 주세요\n\n" +
                    "② 세정제가 적당히 차면 액체가 흘러나오지 않게 잡고, 잡고 있는 아랫부분(이도)을 1분 정도 부드럽게 마사지해 주세요.\n\n" +
                    "③ 밀려나온 귀지를 화장솜 등 부드러운 것으로 닦아 주세요.\n\n" +
                    "④ 귓속에 세정제가 남아 있다면 스스로 털어서 빼낼 수 있도록 놔두셔도 괜찮아요\n\n" +
                    "많은 수의 고양이가 귀에 귀세정제를 넣는 것에 대한 거부감이 심해요\uD83D\uDCA6 만약 귀세정제를 넣는 것에 대해서 매번 거부감이 너무 심하다면 귀세정제를 축축하게 적신 화장솜으로 귀를 가볍게 닦아주는 방법을 이용해 볼 수 있어요!",
            " \uD83D\uDC9C발톱 관리방법\n\n반려묘의 생활 환경 상 발톱이 자연스럽게 마모되지는 않기 때문에 인위적으로 발톱을 잘라주어야해요\n\n고양이별로 차이가 있을 수 있으니 가끔씩 한번 보고 너무 길다 싶으면 한번씩 잘라주세요. 적어도 2주에 한번씩은 꼭 발톱의 길이를 확인해주세요!\n\n" +
                    " \uD83D\uDC8E발톱 깎는 방법\n\n반드시 전용 발톱깎이를 이용해야해요~ 반려묘의 발바닥 패드와 패드사이 한가운데를 눌러보면 발 속에 숨겨뒀던 발톱이 쭉 하고 나와요. 이 발톱을 전용 발톱깎이를 이용해 잘라주세요\n\n" +
                    "고양이의 발을 잡고 발톱을 자세히 보면 투명한 발톱 안쪽으로 핑크빛의 혈관 부분을 자르면 피가 나고 고통이 심하기 때문에 주의를 기울여 그 부위의 아래 쪽만 잘라야해요. ",
            " \uD83D\uDC9C자고 일어나면 자연스럽게 눈꼽이 낄 수 있는데, 이 경우 반려묘가 고양이 세수를 하면서 문질러서 떼어낼 때도 있지만 그렇지 못할 경우 반려인의 도움이 필요해요!!\n\n" +
                    "눈꼽이 마른 상태에서 떼려고 하면 통증을 유발할 수 있으므로 물에 젖은 거즈 등을 이용하여 살살 떼어내 주세요!",
            " \uD83D\uDC9C고양이의 경우는 항문낭을 필수적으로 짜 주기에는 애매한 부분이 있어요\uD83E\uDD14 고양이 특유의 비린내가 항문낭 내용물에 의해 나기도 하는데 그런 경우는 주기적으로 짜 주었을 때 냄새가 많이 줄어들어요~\n\n" +
                    "① 항문낭의 대략적인 위치를 확인해 주세요. 보통 시계방향으로 생각하면 5시, 7시 방향에 있어요.\n\n" +
                    "② 그 부위에서 생각보다 깊은 곳에 손을 위치하고, 눌러서 밀어 올려주는 느낌으로 짜올려 주세요\n\n" +
                    "③ 힘을 많이 주지 않아도 잘 배출되며, 짜는 과정에서 항문낭액이 튈 수 있으므로 물티슈를 항문 부위에 대고 그 위에서 짜는 것이 좋아요~"
    };
}
