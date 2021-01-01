<template>
  <v-app>
    <v-container>
      <div style="width: 100%">

        <div id="selectDiv">


          <v-layout justify-center align-center wrap>
            <v-col
                class="d-flex"
                cols="3"
                md="auto"
                sm="auto">

              <v-select
                  v-on:input="cityChange($event),changeItem('place',$event)"
                  :items="city"
                  label="지역선택"
                  prepend-inner-icon="mdi-map"
                  dense
                  hide-details
                  outlined>

              </v-select>
            </v-col>
            <v-col
                class="d-flex"
                cols="3"
                md="auto"
                sm="auto">
              <v-select
                  v-on:input="changeItem('detail',$event)"
                  :items="area"
                  label="구/군선택"
                  prepend-inner-icon="mdi-map-marker"
                  dense
                  hide-details
                  outlined>

              </v-select>
            </v-col>
            <v-col
                class="d-flex"
                cols="3"
                md="auto"
                sm="auto">
              <v-select
                  v-on:input="changeItem('fish',$event)"
                  :items="kindOfFish"
                  label="어종선택"
                  prepend-inner-icon="mdi-fish"
                  dense
                  hide-details
                  outlined>

              </v-select>
            </v-col>
            <v-col
                class="d-flex"
                cols="3"
                md="auto"
                sm="auto">
              <v-select
                  v-on:input="changeItem('type',$event)"
                  :items="fishingType"
                  label="터 유형 선택"
                  prepend-inner-icon="mdi-island"
                  dense
                  hide-details
                  outlined>

              </v-select>
            </v-col>
          </v-layout>
        </div>

      </div>


        <div class="container" style="margin: auto">
          <v-chip
              v-if="filterItems.fName!=''"
              class="ma-2"
              close
              @click:close="removeItem('fName')"
              color="primary">

            {{ filterItems.fName }}
          </v-chip>
          <v-chip
              v-if="filterItems.place!=''"
              class="ma-2"
              close

              @click:close="removeItem('place')"
              color="primary">

            {{ filterItems.place }}
          </v-chip>

          <v-chip
              v-if="filterItems.detail!=''"
              class="ma-2"
              close
              @click:close="removeItem('detail')"
              color="primary">

            {{ filterItems.detail }}
          </v-chip>

          <v-chip
              v-if="filterItems.fish!=''"
              class="ma-2"
              close
              @click:close="removeItem('fish')"
              color="primary">

            {{ filterItems.fish }}
          </v-chip>

          <v-chip
              v-if="filterItems.type!=''"
              class="ma-2"
              close
              @click:close="removeItem('type')"
              color="primary">

            {{ filterItems.type }}
          </v-chip>


          <br>

          <v-icon color="red"
                  style="cursor:pointer;"
                  @click="clearFilter">
            mdi-restore
          </v-icon>
        </div>



      <br>
      <div id="showDiv" class="row justify-content-center" >
        <p v-if=" propsData && propsData.data.length.toString()==0">

          <br>
          <br>
          필터 키워드

          <span class="badge badge-pill badge-primary">{{filterItems.fName}}</span>
          <span class="badge badge-pill badge-primary">{{filterItems.place}}</span>
          <span class="badge badge-pill badge-primary">{{filterItems.detail}}</span>
          <span class="badge badge-pill badge-primary">{{filterItems.fish}}</span>
          <span class="badge badge-pill badge-primary">{{filterItems.type}}</span>
          를 사용해 검색한 결과가 없어요 ㅠ.ㅠ
        </p>
        <ul v-for="(list,index) in propsData.data" :key="index" style="list-style: none">
          <li>
            <div id="content">
              <div class=" mt-2 rounded float-left"
                   style="width:500px; margin:10px; border:1px solid dodgerblue; height: 700px">
                <div class="card-body">
                  <span><strong> {{ list.fshlcNm }}</strong></span>
                  <hr style=" border: outset 1px; color: blue">
                  <br>
                  <span class="float-left card-subtitle">
                    <v-chip
                      class="ma-2"
                      outlined
                      label
                      small>
                      <v-icon left>mdi-island</v-icon>
                      낚시터 유형
                    </v-chip>
                  : {{ list.fshlcType }}
                </span><br><br>

                  <span class="float-left card-subtitle">
                    <v-chip
                      class="ma-2"
                      outlined
                      label
                      small>
                      <v-icon left color="blue">mdi-fish</v-icon>
                      주요 어종
                    </v-chip>
                  : {{ list.kdfsh }}
                </span><br><br>

                  <span class="float-left card-subtitle">
                     <v-chip
                         class="ma-2"
                         outlined
                         label
                         small>
                      <v-icon left>mdi-cash-usd-outline</v-icon>
                      이용 요금
                    </v-chip>
                  : {{ list.useCharge }}
                </span>
                  <br><br>

                  <span class="float-left card-subtitle">
                     <v-chip
                         class="ma-2"
                         outlined
                         label
                         small>
                      <v-icon left>mdi-format-list-bulleted-type</v-icon>
                      시설물
                    </v-chip>
                    : {{ list.wtrcFcltyType }}
                </span>
                  <br><br>

                  <span class="float-left card-subtitle">
                     <v-chip
                         class="ma-2"
                         outlined
                         label
                         small>
                      <v-icon left>mdi-account-group</v-icon>
                      수용 인원
                    </v-chip>
                 : {{ list.aceptncCo }}
                </span>
                  <br><br>

                  <span class="float-left card-subtitle">
                     <v-chip
                         class="ma-2"
                         outlined
                         label
                         small>
                      <v-icon left>mdi-lifebuoy</v-icon>
                      안전시설
                    </v-chip>
                    : {{ list.safentl }}
                </span>
                  <br><br>

                  <span class="float-left card-subtitle">
                     <v-chip
                         class="ma-2"
                         outlined
                         label
                         small>
                      <v-icon left>mdi-toilet</v-icon>
                      편의시설
                    </v-chip>
                    : {{ list.cvntl }}
                </span>
                  <br><br>

                  <span class="float-left card-subtitle">
                     <v-chip
                         class="ma-2"
                         outlined
                         label
                         small>
                      <v-icon left>mdi-phone-classic</v-icon>
                      전화번호
                    </v-chip>
                    : <span v-if="list.fshlcPhoneNumber=='null' || list.fshlcPhoneNumber.length<5">전화번호가 제공되지 않습니다.</span>
                    <span v-else>{{ list.fshlcPhoneNumber }}</span>
                </span>
                  <br><br>

                  <span class="float-left card-subtitle">
                     <v-chip
                         class="ma-2"
                         outlined
                         label
                         small>
                      <v-icon left>mdi-map-marker</v-icon>
                      주소
                    </v-chip>
                    : <span v-if="list.lnmadr.length>5">{{ list.lnmadr }}</span>
                    <span v-else>{{ list.rdnmadr }}</span>
                </span>
                  <br><br>

                  <span class="float-left card-subtitle">
                     <v-chip
                         class="ma-2"
                         outlined
                         label
                         small>
                      <v-icon left>mdi-origin</v-icon>
                      자료제공
                    </v-chip>
                    : {{ list.institutionNm }}
                </span>
                  <br><br>

                  <span class="float-left card-subtitle" style="font-size: 20px">
                     <v-chip
                         class="ma-2"
                         outlined
                         label
                         small>
                      <v-icon left color="blue">mdi-link-variant-plus</v-icon>
                      Link
                    </v-chip>
                    :
                    <div id="links">
                      <v-btn
                          class="mx-2"
                          fab
                          dark
                          small
                          color="white"
                          @click="searchWeb('naver',list.fshlcNm)">
                        <b style="font-size: 20px; color: green">N</b>
                      </v-btn>
                      <v-btn
                          class="mx-2"
                          fab
                          dark
                          small
                          color="white"
                          @click="searchWeb('naver',list.fshlcNm)">

                    <v-icon
                        color="blue darken-2"
                        style="font-size: 25px"
                        @click="searchWeb('google',list.fshlcNm)">mdi-google-plus
                    </v-icon>
                      </v-btn>
                      <v-btn
                          class="mx-2"
                          fab
                          dark
                          small
                          color="white"
                          @click="searchWeb('insta',list.fshlcNm.replaceAll(' ',''))">
                        <v-icon
                            color="orange darken-2"
                            role="button"
                            class="linkBtn">mdi-instagram
                    </v-icon>
                      </v-btn>

                    </div>
                </span>


                </div>
              </div>
            </div>
          </li>
        </ul>
      </div>

    </v-container>
  </v-app>

</template>

<script>

let cityName = new Array();
cityName['서울시'] = new Array('강남구', '강동구', '강북구', '강서구', '관악구', '광진구', '구로구', '금천구', '노원구', '도봉구', '동대문구', '동작구', '마포구', '서대문구', '서초구', '성동구', '성북구', '송파구', '양천구', '영등포구', '용산구', '은평구', '종로구', '중구', '중랑구');

cityName['부산시'] = new Array('강서구', '금정구', '남구', '동구', '동래구', '부산진구', '북구', '사상구', '사하구', '서구', '수영구', '연제구', '영도구', '중구', '해운대구', '기장군');

cityName['대구시'] = new Array('남구', '달서구', '동구', '북구', '서구', '수성구', '중구', '달성군');

cityName['인천시'] = new Array('계양구', '남구', '남동구', '동구', '부평구', '서구', '연수구', '중구', '강화군', '옹진군');

cityName['광주시'] = new Array('광산구', '남구', '동구', '북구', '서구');

cityName['대전시'] = new Array('대덕구', '동구', '서구', '유성구', '중구');

cityName['울산시'] = new Array('남구', '동구', '북구', '중구', '울주군');

cityName['강원도'] = new Array('강릉시', '동해시', '삼척시', '속초시', '원주시', '춘천시', '태백시', '고성군', '양구군', '양양군', '영월군', '인제군', '정선군', '철원군', '평창군', '홍천군', '화천군', '횡성군');

cityName['경기도'] = new Array('고양시 덕양구', '고양시 일산구', '과천시', '광명시', '광주시', '구리시', '군포시', '김포시', '남양주시', '동두천시', '부천시 소사구', '부천시 오정구', '부천시 원미구', '성남시 분당구', '성남시 수정구', '성남시 중원구', '수원시 권선구', '수원시 장안구', '수원시 팔달구', '시흥시', '안산시 단원구', '안산시 상록구', '안성시', '안양시 동안구', '안양시 만안구', '오산시', '용인시', '의왕시', '의정부시', '이천시', '파주시', '평택시', '하남시', '화성시', '가평군', '양주군', '양평군', '여주군', '연천군', '포천군');

cityName['경상남도'] = new Array('거제시', '김해시', '마산시', '밀양시', '사천시', '양산시', '진주시', '진해시', '창원시', '통영시', '거창군', '고성군', '남해군', '산청군', '의령군', '창녕군', '하동군', '함안군', '함양군', '합천군');

cityName['경상북도'] = new Array('경산시', '경주시', '구미시', '김천시', '문경시', '상주시', '안동시', '영주시', '영천시', '포항시 남구', '포항시 북구', '고령군', '군위군', '봉화군', '성주군', '영덕군', '영양군', '예천군', '울릉군', '울진군', '의성군', '청도군', '청송군', '칠곡군');

cityName['전라남도'] = new Array('광양시', '나주시', '목포시', '순천시', '여수시', '강진군', '고흥군', '곡성군', '구례군', '담양군', '무안군', '보성군', '신안군', '영광군', '영암군', '완도군', '장성군', '장흥군', '진도군', '함평군', '해남군', '화순군');

cityName['전라북도'] = new Array('군산시', '김제시', '남원시', '익산시', '전주시 덕진구', '전주시 완산구', '정읍시', '고창군', '무주군', '부안군', '순창군', '완주군', '임실군', '장수군', '진안군');

cityName['제주도'] = new Array('서귀포시', '제주시', '남제주군', '북제주군');

cityName['충청남도'] = new Array('공주시', '논산시', '보령시', '서산시', '아산시', '천안시', '금산군', '당진군', '부여군', '서천군', '연기군', '예산군', '청양군', '태안군', '홍성군');

cityName['충청북도'] = new Array('제천시', '청주시 상당구', '청주시 흥덕구', '충주시', '괴산군', '단양군', '보은군', '영동군', '옥천군', '음성군', '진천군', '청원군');

export default {
  name: "fishing",
  props: ['propsData'],
  data() {
    return {
      form: '',
      filterItems:{
        place:'',
        detail:'',
        fish:'',
        type:'',
        fName:''

      },
      selectedPlace: '',
      selectedFish: '',
      selectedType: '',
      selectedDetail: '',
      keyword: '',
      type: '',
      si:[],
      area:[],
      kindOfFish:['붕어','잉어','향어','메기','돔','노래미','농어','우럭','숭어','광어','볼락','상어'],
      city:['서울시','부산시','대구시','인천시','광주시','대전시','울산시','강원도','경기도','경상남도','경상북도','전라남도','전라북도','제주도','충청남도','충청북도'],
      fishingType:['저수지','바다','평지','기타']
    }
  },
  methods: {
    cityChange(key) {
      this.area = [];
      if (key == '') return;
      let name = cityName[key];
      for(let i=0; i<name.length; i++)
        this.area.push(name[i]);
    },
    changeItem(changeType, value) {
      console.log("체인지 타입 : " + changeType);
      if (changeType === "place") {
        this.filterItems.place=value;
      } else if (changeType === "fish") {
        this.filterItems = {
          place: this.filterItems.place,
          detail: this.filterItems.detail,
          fish: value,
          fName:this.filterItems.fName,
          type: this.filterItems.type
        }
      } else if (changeType === "detail") {
        this.filterItems = {
          place: this.filterItems.place,
          detail: value,
          fish: this.filterItems.fish,
          fName:this.filterItems.fName,
          type: this.filterItems.type
        }
      } else if (changeType === "type") {
        this.filterItems = {
          place: this.filterItems.place,
          detail: this.filterItems.detail,
          fish: this.filterItems.fish,
          fName:this.filterItems.fName,
          type: value
        }

      }
      else if (changeType === "fName") {
        this.filterItems = {
          fName: value,
          place: this.filterItems.place,
          detail: this.filterItems.detail,
          fish: this.filterItems.fish,
          type: this.filterItems.type
        }
      }
      this.$emit('getFilter', this.filterItems);

    },
    removeItem(removeType) {
      console.log("removeTTTTTYPE : " + removeType);
      if (removeType == "place")
        this.filterItems.place = '';
      if (removeType == "detail")
        this.filterItems.detail = '';
      if (removeType == "fish")
        this.filterItems.fish = '';
      if (removeType == "type")
        this.filterItems.type = '';
      if(removeType=="fName")
        this.filterItems.fName='';
      this.$emit('getFilter', this.filterItems);
    },
    clearFilter(){
      this.filterItems.place = '';
      this.filterItems.detail = '';
      this.filterItems.fish = '';
      this.filterItems.type = '';
      this.filterItems.fName='';


    },
    searchWeb(type, keyword) {
      if (type == 'google')
        window.open("http://google.com/search?q=" + keyword);
      else if (type == 'naver')
        window.open("http://search.naver.com/search.naver?query=" + keyword);
      else if (type == 'insta')
        window.open("http://www.instagram.com/explore/tags/" + keyword);
    },
  }
}
</script>

<style scoped>
#showDiv {
  margin: auto;
}
#selectDiv{
  margin: 0 auto;
}
.d-flex{
  display: inline-block;
}
#links {
  display: inline-block;
}
</style>