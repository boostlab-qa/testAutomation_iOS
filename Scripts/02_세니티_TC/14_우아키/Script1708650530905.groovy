import internal.GlobalVariable

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

//STEP01 - 우아키 화면에서 자녀 키/몸무게 등록
'STEP - 똑닥 앱 실행'
Mobile.startExistingApplication(GlobalVariable.appid)

'STEP - 마이페이지 메뉴 선택'
Mobile.tap(findTestObject('테스트/03_홈/btn_menu_mypage'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 우리아이 키 메뉴 선택'
Mobile.tap(findTestObject('테스트/05_마이페이지/tv_growth_title'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 우아키 화면으로 이동된다.'
Mobile.verifyElementVisible(findTestObject('테스트/13_우아키/tv_title', [('text') : '우리아이 키∙몸무게']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 자녀 필터 선택'
Mobile.tap(findTestObject('테스트/13_우아키/btn_name_click_area'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - "자녀 선택하기" 바텀 시트가 노출된다.'
Mobile.verifyElementVisible(findTestObject('테스트/13_우아키/tv_title', [('text') : '자녀 선택하기']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 추가한 자녀가 없으면 자녀 추가 진행'
if(Mobile.waitForElementNotPresent(findTestObject('테스트/13_우아키/tv_name', [('text') : GlobalVariable.female]), GlobalVariable.waitTime, FailureHandling.CONTINUE_ON_FAILURE))
{
	'STEP - "자녀 선택하기" 바텀 시트에서 [x] 버튼 선택'
	Mobile.tap(findTestObject('테스트/13_우아키/btn_iv_close'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
	'STEP - [<-] 이전 버튼 선택'
	Mobile.tap(findTestObject('테스트/13_우아키/btn_iv_back'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
	'STEP - 마이페이지 [가족관리] 메뉴 선택'
	Mobile.tap(findTestObject('테스트/05_마이페이지/btn_family'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
	'STEP - [자녀추가] 버튼 선택'
	Mobile.tap(findTestObject('테스트/10_가족관리/btn_child_add'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
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
	Mobile.tap(findTestObject('테스트/10_가족관리/btn_add_complet'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
	'STEP - [<-] 이전 버튼 선택'
	Mobile.tap(findTestObject('테스트/00_공통/btn_backBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
	'STEP - 우리아이 키 메뉴 선택'
	Mobile.tap(findTestObject('테스트/05_마이페이지/tv_growth_title'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
	'STEP - 자녀 필터 선택'
	Mobile.tap(findTestObject('테스트/13_우아키/btn_name_click_area'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
}

'STEP - 자녀 이름 선택'
Mobile.tap(findTestObject('테스트/13_우아키/tv_name', [('text') : GlobalVariable.female]), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [키∙몸무게 등록하기] 버튼 선택'
if(Mobile.waitForElementPresent(findTestObject('테스트/13_우아키/btn_register', [('text') : '키∙몸무게 등록하기']), GlobalVariable.waitTime, FailureHandling.CONTINUE_ON_FAILURE))
{
	'STEP - [키∙몸무게 등록하기] 버튼 선택'
	Mobile.tap(findTestObject('테스트/13_우아키/btn_register', [('text') : '키∙몸무게 등록하기']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
}
else
{
	'STEP - [+ 키∙몸무게 등록] 버튼 선택'
	Mobile.tap(findTestObject('테스트/13_우아키/btn_tv_add', [('text') : '키∙몸무게 등록']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
		
}

'기대결과 - "키∙몸무게 등록" 화면으로 이동된다.'
Mobile.verifyElementVisible(findTestObject('테스트/13_우아키/tv_title', [('text') : '키∙몸무게 등록']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 키 입력 영역 선택'
Mobile.tap(findTestObject('테스트/13_우아키/input_et_height'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 키 입력'
Mobile.setText(findTestObject('테스트/13_우아키/input_et_height'), '50', GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 몸무게 입력'
Mobile.setText(findTestObject('테스트/13_우아키/input_et_weight'), '10', GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 키보드 닫기'
Mobile.pressBack()

'STEP - 측정 날짜 저장'
GlobalVariable.today = Mobile.getText(findTestObject('테스트/13_우아키/tv_select_field'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [완료] 버튼 선택'
Mobile.tap(findTestObject('테스트/13_우아키/btn_complete', [('text') : '완료']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 완료 바텀 시트에서 [확인] 버튼 선택'
Mobile.tap(findTestObject('테스트/13_우아키/btn_confirm', [('text') : '확인']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 만족도조사 팝업이 노출되면 [x] 닫기 버튼 선택'
if(Mobile.waitForElementPresent(findTestObject('테스트/13_우아키/btn_modal_close_button'), GlobalVariable.waitTime, FailureHandling.CONTINUE_ON_FAILURE))
{
	'STEP - [x] 버튼 선택'
	Mobile.tap(findTestObject('테스트/13_우아키/btn_modal_close_button'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
}

'기대결과 - 등록한 날짜가 노출된다.'
Mobile.verifyElementVisible(findTestObject('테스트/13_우아키/tv_register_date', [('text') : GlobalVariable.today]), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
'기대결과 - 등록한 키 데이터가 노출된다.'
Mobile.verifyElementVisible(findTestObject('테스트/13_우아키/tv_growth_value', [('text') : '50.00cm']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 몸무게 탭 선택'
Mobile.tap(findTestObject('테스트/13_우아키/btn_tab', [('text') : '몸무게']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 등록한 날짜가 노출된다.'
Mobile.verifyElementVisible(findTestObject('테스트/13_우아키/tv_register_date', [('text') : GlobalVariable.today]), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 등록한 몸무게 데이터가 노출된다.'
Mobile.verifyElementVisible(findTestObject('테스트/13_우아키/tv_growth_value', [('text') : '10.00kg']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 키 탭 선택'
Mobile.tap(findTestObject('테스트/13_우아키/btn_tab', [('text') : '키']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [+ 키∙몸무게 등록] 버튼 선택'
Mobile.tap(findTestObject('테스트/13_우아키/btn_tv_add', [('text') : '키∙몸무게 등록']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - "키∙몸무게 등록" 화면으로 이동된다.'
Mobile.verifyElementVisible(findTestObject('테스트/13_우아키/tv_title', [('text') : '키∙몸무게 등록']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 키 입력 영역 선택'
Mobile.tap(findTestObject('테스트/13_우아키/input_et_height'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 키 입력'
Mobile.setText(findTestObject('테스트/13_우아키/input_et_height'), '80', GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 몸무게 입력'
Mobile.setText(findTestObject('테스트/13_우아키/input_et_weight'), '20', GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 키보드 닫기'
Mobile.pressBack()

'STEP - 측정 날짜 저장'
GlobalVariable.today = Mobile.getText(findTestObject('테스트/13_우아키/tv_select_field'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [완료] 버튼 선택'
Mobile.tap(findTestObject('테스트/13_우아키/btn_complete', [('text') : '완료']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 완료 바텀 시트에서 [확인] 버튼 선택'
Mobile.tap(findTestObject('테스트/13_우아키/btn_confirm', [('text') : '확인']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 만족도조사 팝업이 노출되면 [x] 닫기 버튼 선택'
if(Mobile.waitForElementPresent(findTestObject('테스트/13_우아키/btn_modal_close_button'), GlobalVariable.waitTime, FailureHandling.CONTINUE_ON_FAILURE))
{
	'STEP - [x] 버튼 선택'
	Mobile.tap(findTestObject('테스트/13_우아키/btn_modal_close_button'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
}

'기대결과 - 등록한 날짜가 노출된다.'
Mobile.verifyElementVisible(findTestObject('테스트/13_우아키/tv_register_date', [('text') : GlobalVariable.today]), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
'기대결과 - 등록한 키 데이터가 노출된다.'
Mobile.verifyElementVisible(findTestObject('테스트/13_우아키/tv_growth_value', [('text') : '80.00cm']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - "기록현황" 영역으로 이동'
Mobile.scrollToText('삭제')

'기대결과 - 기록현황 영역에 등록한 날짜 데이터가 노출된다.'
Mobile.verifyElementVisible(findTestObject('테스트/13_우아키/tv_date', [('text') : GlobalVariable.today]), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 기록현황 영역에 등록한 키 데이터가 노출된다.'
Mobile.verifyElementVisible(findTestObject('테스트/13_우아키/tv_value', [('text') : '80.00cm']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 몸무게 탭 선택'
Mobile.tap(findTestObject('테스트/13_우아키/btn_tab', [('text') : '몸무게']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 등록한 날짜가 노출된다.'
Mobile.verifyElementVisible(findTestObject('테스트/13_우아키/tv_register_date', [('text') : GlobalVariable.today]), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 등록한 몸무게 데이터가 노출된다.'
Mobile.verifyElementVisible(findTestObject('테스트/13_우아키/tv_growth_value', [('text') : '20.00kg']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - "기록현황" 영역으로 이동'
Mobile.scrollToText('삭제')

'기대결과 - 기록현황 영역에 등록한 날짜 데이터가 노출된다.'
Mobile.verifyElementVisible(findTestObject('테스트/13_우아키/tv_date', [('text') : GlobalVariable.today]), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 기록현황 영역에 등록한 키 데이터가 노출된다.'
Mobile.verifyElementVisible(findTestObject('테스트/13_우아키/tv_value', [('text') : '20.00kg']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [+ 키∙몸무게 등록] 버튼 선택'
Mobile.tap(findTestObject('테스트/13_우아키/btn_tv_add', [('text') : '키∙몸무게 등록']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - "키∙몸무게 등록" 화면으로 이동된다.'
Mobile.verifyElementVisible(findTestObject('테스트/13_우아키/tv_title', [('text') : '키∙몸무게 등록']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 키∙몸무게 등록 화면에서 [<-] 이전 버튼 선택'
Mobile.tap(findTestObject('테스트/13_우아키/btn_iv_back'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [그만하기] 버튼 선택'
Mobile.tap(findTestObject('테스트/13_우아키/btn_submit_button'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 우아키 화면으로 이동된다.'
Mobile.verifyElementVisible(findTestObject('테스트/13_우아키/tv_title', [('text') : '우리아이 키∙몸무게']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 우아키 화면에서 [<-] 이전 버튼 선택'
Mobile.tap(findTestObject('테스트/13_우아키/btn_iv_back'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 등록한 자녀 삭제'
Mobile.tap(findTestObject('테스트/05_마이페이지/btn_family'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
Mobile.tap(findTestObject('테스트/10_가족관리/txt_name_list', [('text') : GlobalVariable.female]), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
Mobile.scrollToText('편집')
Mobile.tap(findTestObject('테스트/10_가족관리/btn_edit'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
Mobile.tap(findTestObject('테스트/10_가족관리/btn_delete'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
Mobile.tap(findTestObject('테스트/10_가족관리/btn_submit_button'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
Mobile.tap(findTestObject('테스트/00_공통/btn_backBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 앱 종료'
try {
	AppiumDriver<?> driver = MobileDriverFactory.getDriver()
	driver.terminateApp(GlobalVariable.appid)

} catch (Exception e) {
}