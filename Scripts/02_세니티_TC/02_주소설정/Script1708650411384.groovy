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
import com.kms.katalon.core.testobject.ConditionType
import io.appium.java_client.android.nativekey.AndroidKey
import io.appium.java_client.android.nativekey.KeyEvent
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.AppiumDriver
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import io.appium.java_client.MobileElement

//STEP01 - 주소 설정 화면에서 주소 등록 후 선택
'STEP - 똑닥 앱 실행'
Mobile.startExistingApplication(GlobalVariable.appid)

Mobile.delay(5)

'마케팅 수신동의 팝업 노출 시 [좋아요] 선택'  //예외처리
if (Mobile.waitForElementPresent(findTestObject('테스트/03_홈/01_home_popup/btn_maketing_common'), GlobalVariable.waitTime))
{
		Mobile.tap(findTestObject('테스트/03_홈/01_home_popup/btn_maketing_common'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
}

'홈 팝업 노출 시 [오늘 그만 보기] 선택'  //예외처리
if (Mobile.waitForElementPresent(findTestObject('테스트/03_홈/01_home_popup/btn_tv_not_show_today'), GlobalVariable.waitTime))
{
		Mobile.tap(findTestObject('테스트/03_홈/01_home_popup/btn_tv_not_show_today'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
}
	
'STEP - 홈 화면에서 주소 영역 [v] 버튼 선택'
Mobile.tap(findTestObject('테스트/03_홈/btn_iv_arrow'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 로그인 바텀시트가 노출된 경우 로그인 진행'
if(Mobile.waitForElementPresent(findTestObject('테스트/02_로그인/txt_tv_cancel'), GlobalVariable.waitTime))
{
	'STEP - 로그인 바텀 시트에서 [다음에 하기] 선택'
	Mobile.tap(findTestObject('테스트/02_로그인/txt_tv_cancel'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
	'STEP- [마이페이지] 메뉴 선택'
	Mobile.tap(findTestObject('테스트/03_홈/btn_menu_mypage'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
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
	
	'STEP - 홈 화면에서 주소 영역 [v] 버튼 선택'
	Mobile.tap(findTestObject('테스트/03_홈/btn_iv_arrow'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
}

'STEP - 주소설정 화면 [현위치에서 병원 찾기] 버튼 선택'
Mobile.tap(findTestObject('테스트/06_주소설정/btn_current_location'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 홈 화면에서 주소 영역 [v] 버튼 선택'
Mobile.tap(findTestObject('테스트/03_홈/btn_iv_arrow'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 주소 설정 화면으로 이동된다.'
Mobile.verifyElementVisible(findTestObject('테스트/00_공통/txt_page_titleTxt', [('text') : '주소 설정']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [편집] 버튼 선택'
Mobile.tap(findTestObject('테스트/06_주소설정/btn_edit'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 주소 목록 전체 삭제'
while(true)
{
if(Mobile.waitForElementPresent(findTestObject('테스트/06_주소설정/btn_delete'), GlobalVariable.waitTime, FailureHandling.CONTINUE_ON_FAILURE))
{
	'STEP - [삭제] 버튼 선택'
	Mobile.tap(findTestObject('테스트/06_주소설정/btn_delete'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
		
	'STEP - 확인 팝업 [삭제] 버튼 선택'
	Mobile.tap(findTestObject('테스트/06_주소설정/btn_submit_button'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
}
else
	{
		break
	}
}

'STEP - 주소 편집 화면에서 [<-] 뒤로가기 버튼 선택'
Mobile.tap(findTestObject('테스트/06_주소설정/btn_iv_back'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [다른 위치에서 병원 찾기] 버튼 선택'
Mobile.tap(findTestObject('테스트/06_주소설정/btn_different_location'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
'기대결과 - 주소 검색하기 화면으로 이동된다.'
Mobile.verifyElementVisible(findTestObject('테스트/06_주소설정/txt_tv_title', [('text') : '주소 검색하기']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) 
	
'STEP - 주소 입력 영역 선택'
Mobile.tap(findTestObject('테스트/06_주소설정/input_EditText'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
'STEP - 주소 입력'
Mobile.setText(findTestObject('테스트/06_주소설정/input_EditText'), '경기 시흥시 배곧전원로 12-1', GlobalVariable.fixedTime)
	
'STEP - [검색] 버튼 선택'
Mobile.tap(findTestObject('테스트/06_주소설정/btn_adress_search'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
'STEP - 도로명 주소 선택'
Mobile.tap(findTestObject('테스트/06_주소설정/tv_adress', [('text') : '경기 시흥시 배곧전원로 12-1']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
'기대결과 - 상세주소 입력 화면으로 이동된다.'
Mobile.verifyElementVisible(findTestObject('테스트/06_주소설정/tv_toolbar_title', [('text') : '상세주소 입력']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) 
	
'STEP - 상세주소 입력'
Mobile.setText(findTestObject('테스트/06_주소설정/et_input_field', [('text') : '상세주소를 입력해주세요']), '1234', GlobalVariable.fixedTime)
	
'STEP - 주소이름 입력'
Mobile.setText(findTestObject('테스트/06_주소설정/et_input_field', [('text') : '최대 5글자']), '테스트', GlobalVariable.fixedTime)	
	
'STEP - [등록] 버튼 선택'
Mobile.tap(findTestObject('테스트/06_주소설정/btn_dds_submit_button', [('text') : '등록']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 주소 설정 화면으로 이동된다'
Mobile.verifyElementVisible(findTestObject('테스트/00_공통/txt_page_titleTxt', [('text') : '주소 설정']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) 

'기대결과 - 주소 설정 화면에 등록된 주소 이름이 노출된다.'
Mobile.verifyElementVisible(findTestObject('테스트/06_주소설정/txt_tv_title', [('text') : '테스트']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 주소 설정 화면에 등록된 주소가 노출된다.'
Mobile.verifyElementVisible(findTestObject('테스트/06_주소설정/txt_tv_adress', [('text') : '경기 시흥시 배곧전원로 12-1 (배곧동) 1234']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 등록한 주소 선택'
Mobile.tap(findTestObject('테스트/06_주소설정/txt_tv_title', [('text') : '테스트']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 홈 화면으로 이동된다.'
Mobile.verifyElementVisible(findTestObject('테스트/03_홈/btn_menu_home_selected'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 홈 화면 주소 이름 영역에 등록한 주소 이름이 노출된다.'
Mobile.verifyElementVisible(findTestObject('테스트/03_홈/txt_home_adress_name', [('text') : '테스트']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
//

//STEP02 - 주소 설정 화면에서 우리집 주소 선택
'STEP - 홈 화면에서 주소 영역 [v] 버튼 선택'
Mobile.tap(findTestObject('테스트/03_홈/btn_iv_arrow'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 주소 설정 화면으로 이동된다.'
Mobile.verifyElementVisible(findTestObject('테스트/00_공통/txt_page_titleTxt', [('text') : '주소 설정']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 주소 설정 화면 [우리집] 선택'
Mobile.tap(findTestObject('테스트/06_주소설정/txt_tv_title', [('text') : '우리집']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 홈 화면으로 이동된다.'
Mobile.verifyElementVisible(findTestObject('테스트/03_홈/btn_menu_home_selected'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 홈 화면 주소 이름 영역에 "우리집" 주소 이름이 노출된다.'
Mobile.verifyElementVisible(findTestObject('테스트/03_홈/txt_home_adress_name', [('text') : '우리집']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
//

//STEP03 - 주소 설정 화면에서 현위치 주소 선택
'STEP - 홈 화면에서 주소 영역 [v] 버튼 선택'
Mobile.tap(findTestObject('테스트/03_홈/btn_iv_arrow'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 주소 설정 화면으로 이동된다.'
Mobile.verifyElementVisible(findTestObject('테스트/00_공통/txt_page_titleTxt', [('text') : '주소 설정']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 주소설정 화면 [현위치에서 병원 찾기] 버튼 선택'
Mobile.tap(findTestObject('테스트/06_주소설정/btn_current_location'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 홈 화면으로 이동된다.'
Mobile.verifyElementVisible(findTestObject('테스트/03_홈/btn_menu_home_selected'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 홈 화면 주소 이름 영역에 현재 위치에 맞는 주소 이름이 노출된다.'     //집 "상동", 회사 "여의도동"
Mobile.verifyElementVisible(findTestObject('테스트/03_홈/txt_home_adress_name', [('text') : GlobalVariable.adress_name]), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
//

//STEP04 - 주소 설정 화면에서 주소 삭제
'STEP - 홈 화면에서 주소 영역 [v] 버튼 선택'
Mobile.tap(findTestObject('테스트/03_홈/btn_iv_arrow'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 주소 설정 화면으로 이동된다.'
Mobile.verifyElementVisible(findTestObject('테스트/00_공통/txt_page_titleTxt', [('text') : '주소 설정']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [편집] 버튼 선택'
Mobile.tap(findTestObject('테스트/06_주소설정/btn_edit'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 주소 편집 화면으로 이동된다.'
Mobile.verifyElementVisible(findTestObject('테스트/06_주소설정/txt_tv_title', [('text') : '주소 편집']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) 

'STEP - [삭제] 버튼 선택'
Mobile.tap(findTestObject('테스트/06_주소설정/btn_delete'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
		
'STEP - 확인 팝업에서 [삭제] 버튼 선택'
Mobile.tap(findTestObject('테스트/06_주소설정/btn_submit_button'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)		

'기대결과 - 주소 편집 화면에 삭제한 주소 정보가 노출되지 않는다.'
Mobile.verifyElementNotVisible(findTestObject('테스트/03_홈/txt_home_adress_name', [('text') : '테스트']), GlobalVariable.waitTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 주소 편집 화면에서 [<-] 뒤로가기 버튼 선택'
Mobile.tap(findTestObject('테스트/06_주소설정/btn_iv_back'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 주소 설정 화면으로 이동된다.'
Mobile.verifyElementVisible(findTestObject('테스트/00_공통/txt_page_titleTxt', [('text') : '주소 설정']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) 

'기대결과 - 주소 설정 화면에 삭제된 주소 정보가 노출되지 않는다.'
Mobile.verifyElementNotVisible(findTestObject('테스트/03_홈/txt_home_adress_name', [('text') : '테스트']), GlobalVariable.waitTime, FailureHandling.CONTINUE_ON_FAILURE) 

'STEP - 주소 설정 화면에서 뒤로가기 [<-] 버튼 선택'
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