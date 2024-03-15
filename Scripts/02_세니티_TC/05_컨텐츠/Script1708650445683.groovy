import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import io.appium.java_client.android.nativekey.AndroidKey
import io.appium.java_client.android.nativekey.KeyEvent
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.AppiumDriver
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import io.appium.java_client.MobileElement

//STEP01 - 맴버십 구독 여부에 따른 홈 화면 멤버십 구독 유도 영역 확인
'STEP - 똑닥 앱 실행'
Mobile.startExistingApplication(GlobalVariable.appid)

'STEP- [마이페이지] 메뉴 선택'
Mobile.tap(findTestObject('테스트/03_홈/btn_menu_mypage'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 마이페이지 [수정] 버튼 선택'
Mobile.tap(findTestObject('테스트/05_마이페이지/btn_optionalBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [로그아웃] 버튼 선택'
Mobile.tap(findTestObject('테스트/05_마이페이지/tv_title', [('text') : '로그아웃']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [확인] 버튼 선택'
Mobile.tap(findTestObject('테스트/05_마이페이지/tv_title', [('text') : '확인']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 마이페이지 [로그인] 버튼 선택'
Mobile.tap(findTestObject('테스트/05_마이페이지/btn_login'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [이메일 로그인] 버튼 선택'
Mobile.tap(findTestObject('테스트/02_로그인/btn_tvEmailLoginBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 이메일 id 입력'
Mobile.setText(findTestObject('테스트/02_로그인/input_etEmail'), 'qa20@qa.com', GlobalVariable.fixedTime)

'STEP - 이메일 password 입력'
Mobile.setText(findTestObject('테스트/02_로그인/input_etPassword'), GlobalVariable.pw, GlobalVariable.fixedTime)

'STEP - [로그인하기] 버튼 선택'
Mobile.tap(findTestObject('테스트/02_로그인/btn_tvLoginConfirm'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 카카오 전환 유도 팝업 노출 시 [오늘 하루 보지 않기] 버튼 선택'
if (Mobile.waitForElementPresent(findTestObject('테스트/03_홈/01_home_popup/btn_kakao_agree_skip'), GlobalVariable.waitTime))
{
		Mobile.tap(findTestObject('테스트/03_홈/01_home_popup/btn_kakao_agree_skip'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
}

'STEP- [홈] 메뉴 선택'
Mobile.tap(findTestObject('테스트/03_홈/btn_menu_home'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 멤버십 구독 유도 영역이 노출되지 않는다.'
Mobile.verifyElementNotVisible(findTestObject('테스트/03_홈/tv_text', [('text') : '멤버십 구독하기']), GlobalVariable.waitTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP- [마이페이지] 메뉴 선택'
Mobile.tap(findTestObject('테스트/03_홈/btn_menu_mypage'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 마이페이지 [수정] 버튼 선택'
Mobile.tap(findTestObject('테스트/05_마이페이지/btn_optionalBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [로그아웃] 버튼 선택'
Mobile.tap(findTestObject('테스트/05_마이페이지/tv_title', [('text') : '로그아웃']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [확인] 버튼 선택'
Mobile.tap(findTestObject('테스트/05_마이페이지/tv_title', [('text') : '확인']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 마이페이지 [로그인] 버튼 선택'
Mobile.tap(findTestObject('테스트/05_마이페이지/btn_login'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [이메일 로그인] 버튼 선택'
Mobile.tap(findTestObject('테스트/02_로그인/btn_tvEmailLoginBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 이메일 id 입력'
Mobile.setText(findTestObject('테스트/02_로그인/input_etEmail'), GlobalVariable.id_90000, GlobalVariable.fixedTime)

'STEP - 이메일 password 입력'
Mobile.setText(findTestObject('테스트/02_로그인/input_etPassword'), GlobalVariable.pw, GlobalVariable.fixedTime)

'STEP - [로그인하기] 버튼 선택'
Mobile.tap(findTestObject('테스트/02_로그인/btn_tvLoginConfirm'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 카카오 전환 유도 팝업 노출 시 [오늘 하루 보지 않기] 버튼 선택'
if (Mobile.waitForElementPresent(findTestObject('테스트/03_홈/01_home_popup/btn_kakao_agree_skip'), GlobalVariable.waitTime))
{
		Mobile.tap(findTestObject('테스트/03_홈/01_home_popup/btn_kakao_agree_skip'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
}

'STEP - 홈 메뉴 선택'
Mobile.tap(findTestObject('테스트/03_홈/btn_menu_home'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 홈 화면에 멤버십 구독 유도 영역이 노출된다.'
Mobile.verifyElementVisible(findTestObject('테스트/03_홈/tv_text', [('text') : '멤버십 구독하기']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 멤버십 구독 유도 영역 선택'
Mobile.tap(findTestObject('테스트/03_홈/tv_text', [('text') : '멤버십 구독하기']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 멤버십 구독 안내 화면이 노출된다.'
Mobile.verifyElementVisible(findTestObject('테스트/03_홈/btn_button_submit'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 멤버십 구독 안내 화면 [x] 버튼 선택'
Mobile.tap(findTestObject('테스트/00_공통/btn_backBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
//

//STEP02 - [동네 인기 병원] 컨텐츠 선택하여 검색 동작 확인
'STEP - [동네 인기 병원] 컨텐츠 선택'
Mobile.tap(findTestObject('테스트/03_홈/02_contents/txt_tv_title', [('text') : '동네 인기 병원']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 검색목록이 노출되지 않으면 화면 재 진입'
if (Mobile.waitForElementNotPresent(findTestObject('테스트/07_검색/txt_hospital_name'), GlobalVariable.waitTime))
{
		'STEP - 검색 화면 [<-] 뒤로가기 버튼 선택'
		Mobile.tap(findTestObject('테스트/00_공통/btn_backBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
		
		'STEP - [동네 인기 병원] 컨텐츠 선택'
		Mobile.tap(findTestObject('테스트/03_홈/02_contents/txt_tv_title', [('text') : '동네 인기 병원']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
}

'기대결과 - 검색 화면으로 이동된다.'
Mobile.verifyElementVisible(findTestObject('테스트/07_검색/txt_searchInput', [('text') : '인기 많은 똑닥 병원']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - Sort 타입에 "인기순" 필터가 적용된다.'
Mobile.verifyElementVisible(findTestObject('테스트/07_검색/btn_tvSortType', [('text') : '인기순']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 검색 결과 영역에 병원 목록이 노출된다.'
Mobile.verifyElementVisible(findTestObject('테스트/07_검색/txt_hospital_name'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 검색 화면 [<-] 뒤로가기 버튼 선택'
Mobile.tap(findTestObject('테스트/00_공통/btn_backBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 홈 화면으로 이동된다.'
Mobile.verifyElementVisible(findTestObject('테스트/03_홈/btn_menu_home_selected'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) 

//STEP03 - [지금 문연 병원] 컨텐츠 선택하여 검색 동작 확인
'STEP - [지금 문연 병원] 컨텐츠 선택'
Mobile.tap(findTestObject('테스트/03_홈/02_contents/txt_tv_title', [('text') : '지금 문연 병원']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 검색 화면으로 이동된다.'
Mobile.verifyElementVisible(findTestObject('테스트/07_검색/txt_searchInput', [('text') : '지금문연병원']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - Sort 타입에 "관련순" 필터가 적용된다.'
Mobile.verifyElementVisible(findTestObject('테스트/07_검색/btn_tvSortType', [('text') : '관련순']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - [진료중] 필터가 활성화된다.'
Mobile.verifyElementVisible(findTestObject('테스트/07_검색/btn_filter_open_on'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) 

'기대결과 - 검색 결과 영역에 병원 목록이 노출된다.'
Mobile.verifyElementVisible(findTestObject('테스트/07_검색/txt_hospital_name'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [<-] 뒤로가기 버튼 선택'
Mobile.tap(findTestObject('테스트/00_공통/btn_backBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 홈 화면으로 이동'
Mobile.verifyElementVisible(findTestObject('테스트/03_홈/btn_menu_home_selected'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
//

'STEP - 홈 컨텐츠 (진료과로 병원 찾기) 아이콘 미노출 상태면 스크롤 이동'
if (Mobile.waitForElementNotPresent(findTestObject('테스트/03_홈/02_contents/txt_find_hospital_paediatrics'), GlobalVariable.waitTime))
{
	'STEP - 화면 스크롤 이동'
	Mobile.scrollToText('진료과로 병원 찾기 🏥')
}

//STEP04 - 추천 컨텐츠 선택하여 화면 이동 동작 확인
'STEP - 홈 추천 컨텐츠 선택'
Mobile.tap(findTestObject('테스트/03_홈/02_contents/btn_frame_image_section'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 우아키 화면으로 이동된다.'
Mobile.verifyElementVisible(findTestObject('테스트/13_우아키/tv_title', [('text') : '우리아이 키∙몸무게']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 키 탭이 선택 상태로 노출된다.'
Mobile.verifyElementVisible(findTestObject('테스트/13_우아키/btn_tab_selected', [('text') : '키']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 우아키 화면에서 [<-] 뒤로가기 버튼 선택'
Mobile.tap(findTestObject('테스트/13_우아키/btn_iv_back'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 소개 페이지 뒤로가기 key 선택'
Mobile.pressBack()

'기대결과 - 홈 화면으로 이동된다.'
Mobile.verifyElementVisible(findTestObject('테스트/03_홈/btn_menu_home_selected'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
//

//STEP05 - 진료과로 병원 찾기 컨텐츠 선택하여 검색 동작 확인
'STEP - 홈 컨텐츠 "소아청소년과" 미노출 상태면 스크롤 이동'
if (Mobile.waitForElementNotPresent(findTestObject('테스트/03_홈/02_contents/txt_find_hospital_paediatrics'), GlobalVariable.waitTime))
{
	'STEP - 화면 스크롤 이동'
	Mobile.scrollToText('소아청소년과')
}
	
'STEP - [소아청소년과] 진료과 컨텐츠 선택'
Mobile.tap(findTestObject('테스트/03_홈/02_contents/txt_find_hospital_paediatrics'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 검색 화면으로 이동된다.'
Mobile.verifyElementVisible(findTestObject('테스트/07_검색/txt_searchInput', [('text') : '소아청소년과']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 진료과목 필터에 "소아청소년과"가 적용된다.'
Mobile.verifyElementVisible(findTestObject('테스트/07_검색/btn_commonBtnTitle', [('text') : '소아청소년과']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - Sort 타입에 "관련순" 필터가 적용된다.'
Mobile.verifyElementVisible(findTestObject('테스트/07_검색/btn_tvSortType', [('text') : '관련순']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 검색 결과 영역에 병원 목록이 노출된다.'
Mobile.verifyElementVisible(findTestObject('테스트/07_검색/txt_hospital_name'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) 

'기대결과 - 결과 목록 대표 진료과목 영역에 검색한 진료과목이 노출된다.'
Mobile.verifyElementVisible(findTestObject('테스트/07_검색/txt_categoryTxt', [('text') : '소아청소년과']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [진료과목] 필터 선택'
Mobile.tap(findTestObject('테스트/07_검색/btn_medical_department'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 진료과목 바텀 시트가 노출된다.'
Mobile.verifyElementVisible(findTestObject('테스트/07_검색/txt_bottom_seat_title', [('text') : '진료과목']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 진료과목 [내과] 선택'
Mobile.tap(findTestObject('테스트/07_검색/txt_medical_department_filter_list', [('text') : '내과']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 진료과목 필터 문구가 [내과]로 노출된다.'
Mobile.verifyElementVisible(findTestObject('테스트/07_검색/btn_commonBtnTitle', [('text') : '내과']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 결과 목록 대표 진료과목 영역에 검색한 진료과목이 노출된다.'
Mobile.verifyElementVisible(findTestObject('테스트/07_검색/txt_categoryTxt', [('text') : '내과']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 검색 화면에서 [<-] 뒤로가기 버튼 선택'
Mobile.tap(findTestObject('테스트/00_공통/btn_backBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 홈 화면으로 이동된다.'
Mobile.verifyElementVisible(findTestObject('테스트/03_홈/btn_menu_home_selected'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [이비인후과] 진료과 컨텐츠 선택'
Mobile.tap(findTestObject('테스트/03_홈/02_contents/txt_find_hospital_otolaryngology'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 검색 화면으로 이동된다.'
Mobile.verifyElementVisible(findTestObject('테스트/07_검색/txt_searchInput', [('text') : '이비인후과']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 진료과목 필터에 "소아청소년과"가 적용된다.'
Mobile.verifyElementVisible(findTestObject('테스트/07_검색/btn_commonBtnTitle', [('text') : '이비인후과']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - Sort 타입에 "관련순" 필터가 적용된다.'
Mobile.verifyElementVisible(findTestObject('테스트/07_검색/btn_tvSortType', [('text') : '관련순']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 검색 결과 영역에 병원 목록이 노출된다.'
Mobile.verifyElementVisible(findTestObject('테스트/07_검색/txt_hospital_name'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 결과 목록 대표 진료과목 영역에 검색한 진료과목이 노출된다.'
Mobile.verifyElementVisible(findTestObject('테스트/07_검색/txt_categoryTxt', [('text') : '이비인후과']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [진료과목] 필터 선택'
Mobile.tap(findTestObject('테스트/07_검색/btn_medical_department'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 진료과목 바텀 시트가 노출된다.'
Mobile.verifyElementVisible(findTestObject('테스트/07_검색/txt_bottom_seat_title', [('text') : '진료과목']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 진료과목 [소아청소년과] 선택'
Mobile.tap(findTestObject('테스트/07_검색/txt_medical_department_filter_list', [('text') : '소아청소년과']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 진료과목 필터 문구가 [소아청소년과]로 노출된다.'
Mobile.verifyElementVisible(findTestObject('테스트/07_검색/btn_commonBtnTitle', [('text') : '소아청소년과']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 검색 결과 영역에 병원 목록이 노출된다.'
Mobile.verifyElementVisible(findTestObject('테스트/07_검색/txt_hospital_name'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 결과 목록 대표 진료과목 영역에 검색한 진료과목이 노출된다.'
Mobile.verifyElementVisible(findTestObject('테스트/07_검색/txt_categoryTxt', [('text') : '소아청소년과']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 검색 화면에서 [<-] 뒤로가기 버튼 선택'
Mobile.tap(findTestObject('테스트/00_공통/btn_backBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 홈 화면으로 이동된다.'
Mobile.verifyElementVisible(findTestObject('테스트/03_홈/btn_menu_home_selected'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
//

//STEP06 - 이런 병원 찾고 계신가요? 컨텐츠 선택하여 검색 동작 확인
'STEP - 화면 스크롤 이동'
Mobile.scrollToText('똑닥 예약 병원')

'STEP - 이런 병원 찾고 계신가요? [똑닥 예약 병원] 컨텐츠 선택'
Mobile.tap(findTestObject('테스트/03_홈/02_contents/txt_like_hospital_reservation'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 검색 화면으로 이동된다.'
Mobile.verifyElementVisible(findTestObject('테스트/07_검색/txt_searchInput', [('text') : '똑닥 예약 병원']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - Sort 타입에 "관련순" 필터가 적용된다.'
Mobile.verifyElementVisible(findTestObject('테스트/07_검색/btn_tvSortType', [('text') : '관련순']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 검색 결과 영역에 병원 목록이 노출된다.'
Mobile.verifyElementVisible(findTestObject('테스트/07_검색/txt_hospital_name'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 검색 화면에서 [<-] 뒤로가기 버튼 선택'
Mobile.tap(findTestObject('테스트/00_공통/btn_backBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 홈 화면으로 이동된다.'
Mobile.verifyElementVisible(findTestObject('테스트/03_홈/btn_menu_home_selected'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
//

//STEP07 - [영유아 검진 예약하기] 컨텐츠 선택하여 검색 동작 확인
'STEP - [영유아 검진 예약하기] 컨텐츠 선택'
Mobile.tap(findTestObject('테스트/03_홈/02_contents/img_infant_check-up'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 검색 화면으로 이동된다.'
Mobile.verifyElementVisible(findTestObject('테스트/07_검색/txt_searchInput', [('text') : '영유아검진']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - Sort 타입에 "관련순" 필터가 적용된다.'
Mobile.verifyElementVisible(findTestObject('테스트/07_검색/btn_tvSortType', [('text') : '관련순']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 검색 결과 영역에 병원 목록이 노출된다.'
Mobile.verifyElementVisible(findTestObject('테스트/07_검색/txt_hospital_name'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 병원 정보에 [영유아검진] 뱃지가 노출된다.'
Mobile.verifyElementVisible(findTestObject('테스트/07_검색/txt_badge', [('text') : '영유아검진']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) 

'STEP - 검색 화면에서 [<-] 뒤로가기 버튼 선택'
Mobile.tap(findTestObject('테스트/00_공통/btn_backBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 홈 화면으로 이동된다.'
Mobile.verifyElementVisible(findTestObject('테스트/03_홈/btn_menu_home_selected'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
//

'STEP - 앱 종료'
try {
	AppiumDriver<?> driver = MobileDriverFactory.getDriver()
	driver.terminateApp(GlobalVariable.appid)

} catch (Exception e) {
}