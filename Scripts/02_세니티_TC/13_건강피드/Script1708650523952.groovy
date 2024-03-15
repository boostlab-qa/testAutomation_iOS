import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
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

//STEP01 - 건강피드 화면에서 자녀 추가
'STEP - 똑닥 앱 실행'
Mobile.startExistingApplication(GlobalVariable.appid)

'STEP - 마이페이지 메뉴 선택'
Mobile.tap(findTestObject('테스트/03_홈/btn_menu_mypage'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 건강피드 메뉴 선택'
Mobile.tap(findTestObject('테스트/05_마이페이지/btn_healthy_feed'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 건강피드 화면으로 이동된다.'
Mobile.verifyElementVisible(findTestObject('테스트/00_공통/txt_page_titleTxt', [('text') : '건강피드']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 자녀 필터 선택'
Mobile.tap(findTestObject('테스트/11_건강피드/txt_child_name'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 자녀 이름이 노출되지 않으면 자녀 추가'
if(Mobile.waitForElementNotPresent(findTestObject('테스트/11_건강피드/txt_filter_list_name', [('text') : GlobalVariable.female]), GlobalVariable.waitTime, FailureHandling.CONTINUE_ON_FAILURE))
{
	'STEP - [자녀추가] 항목 선택'
	Mobile.tap(findTestObject('테스트/11_건강피드/txt_filter_list_name', [('text') : '자녀추가 (12세 미만)']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
	'기대결과 - 자녀추가 화면으로 이동된다.'
	Mobile.verifyElementVisible(findTestObject('테스트/00_공통/txt_page_titleTxt', [('text') : '자녀추가']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
	'STEP - 이름 입력'
	Mobile.setText(findTestObject('테스트/10_가족관리/input_add_family_name'), GlobalVariable.female, GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
	'STEP - 키보드 닫기'
	Mobile.pressBack()
	
	'STEP - 주민번호 앞자리 입력'
	Mobile.setText(findTestObject('테스트/10_가족관리/input_add_ssn_front_number'), GlobalVariable.male_birth_date, GlobalVariable.fixedTime)
	
	'STEP - 주민번호 뒷자리 영역 선택'
	Mobile.tap(findTestObject('테스트/10_가족관리/tv_et_ssn_back_number'), GlobalVariable.fixedTime, FailureHandling.STOP_ON_FAILURE)
	
	'STEP - 주민번호 뒷자리 "4444444" 입력'
	for(i = 1; i <= 7; i++)
	{
		Mobile.tap(findTestObject('테스트/10_가족관리/btn_keypad_number', [('text') : '4']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	}
	
	'STEP - 화면 스크롤 이동'
	Mobile.scrollToText('고유식별정보의 수집 및 이용 동의')
	
	'STEP - 이용약관 가족 대리 접수 동의 체크 선택'
	Mobile.tap(findTestObject('테스트/10_가족관리/btn_add_use', [('text') : '자녀 대리 접수 동의']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
	'STEP - 이용약관 똑닥 QR 진료카드 체크 선택'
	Mobile.tap(findTestObject('테스트/10_가족관리/btn_add_use', [('text') : '고유식별정보의 수집 및 이용 동의']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
	'STEP - [완료] 버튼 선택'
	Mobile.tap(findTestObject('테스트/10_가족관리/btn_rb_complete'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
	'STEP - 자녀 필터 선택'
	Mobile.tap(findTestObject('테스트/11_건강피드/txt_child_name'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
}

'기대결과 - 필터 목록에 추가한 자녀 이름이 노출된다.'
Mobile.verifyElementVisible(findTestObject('테스트/11_건강피드/txt_filter_list_name', [('text') : GlobalVariable.female]), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
//

//STEP02 - 자녀 체온 등록하고 상태 확인
'STEP - 가족 선택 팝업에서 자녀 이름 선택'
Mobile.tap(findTestObject('테스트/11_건강피드/txt_filter_list_name', [('text') : GlobalVariable.female]), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 체온관리 tab 선택'
Mobile.tap(findTestObject('테스트/11_건강피드/btn_tab', [('text') : '체온관리']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [+] 버튼 선택'
Mobile.tap(findTestObject('테스트/11_건강피드/btn_add'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [체온 등록] 선택'
Mobile.tap(findTestObject('테스트/11_건강피드/txt_add', [('text') : '체온 등록']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 체온관리 화면으로 이동된다.'
Mobile.verifyElementVisible(findTestObject('테스트/00_공통/txt_page_titleTxt', [('text') : '체온관리']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 체온 입력 영역 선택'
Mobile.tap(findTestObject('테스트/11_건강피드/txt_tvTemperature'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 체온 직접 입력 팝업이 노출된다.'
Mobile.verifyElementVisible(findTestObject('테스트/00_공통/txt_page_titleTxt', [('text') : '체온 직접 입력']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 체온 입력'
Mobile.setText(findTestObject('테스트/11_건강피드/input_number'), '36', GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [확인] 선택'
Mobile.tap(findTestObject('테스트/11_건강피드/btn_positive'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 체온 입력 영역에 등록한 체온 데이터가 노출된다.'
Mobile.verifyElementVisible(findTestObject('테스트/11_건강피드/txt_temperature', [('text') : '36°C']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [등록 완료] 버튼 선택'
Mobile.tap(findTestObject('테스트/00_공통/btn_confirmBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 체온관리 tab 화면에 등록한 체온 데이터가 노출된다.'
Mobile.verifyElementVisible(findTestObject('테스트/11_건강피드/txt_temperatureTxt', [('text') : '36 ℃']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 체온 상태 문구가 노출된다.'
Mobile.verifyElementVisible(findTestObject('테스트/11_건강피드/txt_temperature_state', [('text') : '정상 체온 상태']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [+] 버튼 선택'
Mobile.tap(findTestObject('테스트/11_건강피드/btn_add'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [체온 등록] 선택'
Mobile.tap(findTestObject('테스트/11_건강피드/txt_add', [('text') : '체온 등록']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 체온관리 화면으로 이동'
Mobile.verifyElementVisible(findTestObject('테스트/00_공통/txt_page_titleTxt', [('text') : '체온관리']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 체온 입력 영역 선택'
Mobile.tap(findTestObject('테스트/11_건강피드/txt_tvTemperature'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 체온 직접 입력 팝업이 노출된다.'
Mobile.verifyElementVisible(findTestObject('테스트/00_공통/txt_page_titleTxt', [('text') : '체온 직접 입력']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 체온 입력'
Mobile.setText(findTestObject('테스트/11_건강피드/input_number'), '38', GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [확인] 선택'
Mobile.tap(findTestObject('테스트/11_건강피드/btn_positive'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 체온 입력 영역에 등록한 체온 데이터가 노출된다.'
Mobile.verifyElementVisible(findTestObject('테스트/11_건강피드/txt_temperature', [('text') : '38°C']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [등록 완료] 버튼 선택'
Mobile.tap(findTestObject('테스트/00_공통/btn_confirmBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 체온관리 tab 화면에 등록한 체온 데이터가 노출된다.'
Mobile.verifyElementVisible(findTestObject('테스트/11_건강피드/txt_temperatureTxt', [('text') : '38 ℃']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 체온 상태 문구가 노출된다.'
Mobile.verifyElementVisible(findTestObject('테스트/11_건강피드/txt_temperature_state', [('text') : '미열 상태']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [+] 버튼 선택'
Mobile.tap(findTestObject('테스트/11_건강피드/btn_add'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [체온 등록] 선택'
Mobile.tap(findTestObject('테스트/11_건강피드/txt_add', [('text') : '체온 등록']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 체온관리 화면으로 이동'
Mobile.verifyElementVisible(findTestObject('테스트/00_공통/txt_page_titleTxt', [('text') : '체온관리']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 체온 입력 영역 선택'
Mobile.tap(findTestObject('테스트/11_건강피드/txt_tvTemperature'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 체온 직접 입력 팝업 노출'
Mobile.verifyElementVisible(findTestObject('테스트/00_공통/txt_page_titleTxt', [('text') : '체온 직접 입력']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 체온 입력'
Mobile.setText(findTestObject('테스트/11_건강피드/input_number'), '39', GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [확인] 선택'
Mobile.tap(findTestObject('테스트/11_건강피드/btn_positive'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 체온 입력 영역에 등록한 체온 데이터가 노출된다.'
Mobile.verifyElementVisible(findTestObject('테스트/11_건강피드/txt_temperature', [('text') : '39°C']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [등록 완료] 버튼 선택'
Mobile.tap(findTestObject('테스트/00_공통/btn_confirmBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 체온관리 tab 화면에 등록한 체온 데이터가 노출된다.'
Mobile.verifyElementVisible(findTestObject('테스트/11_건강피드/txt_temperatureTxt', [('text') : '39 ℃']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 체온 상태 문구가 노출된다.'
Mobile.verifyElementVisible(findTestObject('테스트/11_건강피드/txt_temperature_state', [('text') : '고열 상태']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
//

//STEP03 - 건강피드 TAB 화면에서 필터 변경
'STEP - 건강피드 화면에서 [<-] 이전 버튼 선택'
Mobile.tap(findTestObject('테스트/00_공통/btn_backBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 마이페이지에서 건강피드 메뉴 선택'
Mobile.tap(findTestObject('테스트/05_마이페이지/btn_healthy_feed'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 건강피드 tab 선택'
Mobile.tap(findTestObject('테스트/11_건강피드/btn_tab', [('text') : '건강피드']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 보기 필터 선택'
Mobile.tap(findTestObject('테스트/11_건강피드/btn_filter'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 피드 필터 팝업 노출'
Mobile.verifyElementVisible(findTestObject('테스트/00_공통/txt_page_titleTxt', [('text') : '피드 필터']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 체온 (체온, 해열제) 옵션 선택'
Mobile.tap(findTestObject('테스트/11_건강피드/txt_filter_list_name', [('text') : '체온 (체온, 해열제)']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 체온 피드 목록이 노출된다.'
Mobile.verifyElementVisible(findTestObject('테스트/11_건강피드/txt_feed_title', [('text') : '39 ℃']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
Mobile.verifyElementVisible(findTestObject('테스트/11_건강피드/txt_feed_title', [('text') : '38 ℃']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
Mobile.verifyElementVisible(findTestObject('테스트/11_건강피드/txt_feed_title', [('text') : '36 ℃']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

//STEP04 - 검진/접종 탭에서 버튼 동작 확인
'STEP - 자녀 필터 선택'
Mobile.tap(findTestObject('테스트/11_건강피드/txt_child_name'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 가족 선택 팝업에서 자녀 이름 선택'
Mobile.tap(findTestObject('테스트/11_건강피드/txt_filter_list_name', [('text') : '영유아']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 검진/접종 tab 선택'
Mobile.tap(findTestObject('테스트/11_건강피드/btn_tab', [('text') : '검진/접종']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - "영유아검진" 토글 선택'
Mobile.tap(findTestObject('테스트/11_건강피드/btn_foregroundSwitchLeft', [('text') : '영유아검진']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [최근 병원예약] 버튼이 노출되는 경우 버튼 선택'
if(Mobile.waitForElementPresent(findTestObject('테스트/11_건강피드/btn_tvRecent', [('text') : '최근 병원예약']), GlobalVariable.waitTime, FailureHandling.CONTINUE_ON_FAILURE))
{
	'STEP - [최근 병원예약] 버튼 선택'
	Mobile.tap(findTestObject('테스트/11_건강피드/btn_tvRecent', [('text') : '최근 병원예약']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
	'기대결과 - 예약하기 화면으로 이동된다.'
	Mobile.verifyElementVisible(findTestObject('테스트/09_접수/txt_reservation_title'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
	'STEP - [x] 버튼 선택'
	Mobile.tap(findTestObject('테스트/00_공통/btn_backBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
	'STEP - [네] 버튼 선택'
	Mobile.tap(findTestObject('테스트/09_접수/btn_confirm'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
	'기대결과 - 건강피드 화면으로 이동된다.'
	Mobile.verifyElementVisible(findTestObject('테스트/00_공통/txt_page_titleTxt', [('text') : '건강피드']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
}

'STEP - [주변 병원보기] 버튼만 노출되는 경우 버튼 선택'
if(Mobile.waitForElementPresent(findTestObject('테스트/11_건강피드/btn_tvQuestionnaireTitle', [('text') : '주변 병원보기']), GlobalVariable.waitTime, FailureHandling.CONTINUE_ON_FAILURE))
{
	'STEP - [주변 병원보기] 버튼 선택'
	Mobile.tap(findTestObject('테스트/11_건강피드/btn_tvQuestionnaireTitle', [('text') : '주변 병원보기']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
	'기대결과 - 검색 화면으로 이동되고 "영유아검진" 검색어가 입력 상태로 노출된다.'
	Mobile.verifyElementVisible(findTestObject('테스트/07_검색/txt_searchInput', [('text') : '영유아검진']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
	'기대결과 - Sort 타입에 "관련순" 필터가 적용된다.'
	Mobile.verifyElementVisible(findTestObject('테스트/07_검색/btn_tvSortType', [('text') : '관련순']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
	'기대결과 - 검색 결과 영역에 병원 목록이 노출된다.'
	Mobile.verifyElementVisible(findTestObject('테스트/07_검색/txt_hospital_name'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
	'기대결과 - 병원 정보에 [영유아검진] 뱃지가 노출된다.'
	Mobile.verifyElementVisible(findTestObject('테스트/07_검색/txt_badge', [('text') : '영유아검진']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
	'STEP - 검색 화면에서 [<-] 뒤로가기 버튼 선택'
	Mobile.tap(findTestObject('테스트/00_공통/btn_backBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
	'기대결과 - 건강피드 화면으로 이동된다.'
	Mobile.verifyElementVisible(findTestObject('테스트/00_공통/txt_page_titleTxt', [('text') : '건강피드']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
}

'STEP - [최근 병원예약] [주변 병원보기] 버튼이 노출되는 경우 [주변 병원보기] 버튼 선택'
if(Mobile.waitForElementPresent(findTestObject('테스트/11_건강피드/btn_tvNear', [('text') : '주변 병원보기']), GlobalVariable.waitTime, FailureHandling.CONTINUE_ON_FAILURE))
{
	'STEP - [주변 병원보기] 버튼 선택'
	Mobile.tap(findTestObject('테스트/11_건강피드/btn_tvNear', [('text') : '주변 병원보기']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
	'기대결과 - 검색 화면으로 이동되고 "영유아검진" 검색어가 입력 상태로 노출된다.'
	Mobile.verifyElementVisible(findTestObject('테스트/07_검색/txt_searchInput', [('text') : '영유아검진']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
	'기대결과 - Sort 타입에 "관련순" 필터가 적용된다.'
	Mobile.verifyElementVisible(findTestObject('테스트/07_검색/btn_tvSortType', [('text') : '관련순']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
	'기대결과 - 검색 결과 영역에 병원 목록이 노출된다.'
	Mobile.verifyElementVisible(findTestObject('테스트/07_검색/txt_hospital_name'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
	'기대결과 - 병원 정보에 [영유아검진] 뱃지가 노출된다.'
	Mobile.verifyElementVisible(findTestObject('테스트/07_검색/txt_badge', [('text') : '영유아검진']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
	'STEP - 검색 화면에서 [<-] 뒤로가기 버튼 선택'
	Mobile.tap(findTestObject('테스트/00_공통/btn_backBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
	'기대결과 - 건강피드 화면으로 이동된다.'
	Mobile.verifyElementVisible(findTestObject('테스트/00_공통/txt_page_titleTxt', [('text') : '건강피드']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
}

'STEP - [예방접종] 토글 버튼 선택'
Mobile.tap(findTestObject('테스트/11_건강피드/btn_rightBtn', [('text') : '예방접종']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [주변 병원보기] 버튼이 노출되면 선택'
if(Mobile.waitForElementPresent(findTestObject('테스트/11_건강피드/btn_tvQuestionnaireTitle', [('text') : '주변 병원보기']), GlobalVariable.waitTime, FailureHandling.CONTINUE_ON_FAILURE))
{
	'STEP - [주변 병원보기] 버튼 선택'
	Mobile.tap(findTestObject('테스트/11_건강피드/btn_tvQuestionnaireTitle', [('text') : '주변 병원보기']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
	'기대결과 - 검색 화면으로 이동되고 "예방접종" 검색어가 입력 상태로 노출된다.'
	Mobile.verifyElementVisible(findTestObject('테스트/07_검색/txt_searchInput', [('text') : '예방접종']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
	'기대결과 - Sort 타입에 "관련순" 필터가 적용된다.'
	Mobile.verifyElementVisible(findTestObject('테스트/07_검색/btn_tvSortType', [('text') : '관련순']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
	'기대결과 - 검색 결과 영역에 병원 목록이 노출된다.'
	Mobile.verifyElementVisible(findTestObject('테스트/07_검색/txt_hospital_name'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
	'기대결과 - 병원 정보에 [영유아검진] 뱃지가 노출된다.'
	Mobile.verifyElementVisible(findTestObject('테스트/07_검색/txt_badge', [('text') : '예방접종']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
	'STEP - 검색 화면에서 [<-] 뒤로가기 버튼 선택'
	Mobile.tap(findTestObject('테스트/00_공통/btn_backBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
	'기대결과 - 건강피드 화면으로 이동된다.'
	Mobile.verifyElementVisible(findTestObject('테스트/00_공통/txt_page_titleTxt', [('text') : '건강피드']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
}

'STEP - 건강피드 화면에서 [<-] 이전 버튼 선택'
Mobile.tap(findTestObject('테스트/00_공통/btn_backBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 마이페이지로 이동된다.'
Mobile.verifyElementVisible(findTestObject('테스트/05_마이페이지/btn_healthy_feed'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 앱 종료'
try {
	AppiumDriver<?> driver = MobileDriverFactory.getDriver()
	driver.terminateApp(GlobalVariable.appid)

} catch (Exception e) {
}