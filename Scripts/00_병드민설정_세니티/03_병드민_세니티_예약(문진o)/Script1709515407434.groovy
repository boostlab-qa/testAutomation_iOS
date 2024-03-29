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

//병드민 : 접수OFF, 예약ON, 사전문진ON, 영유아검진ON, 간편결제ON

'STEP - 병원 어드민 접속'
WebUI.openBrowser(GlobalVariable.url)

'STEP - 화면 최대화'
WebUI.maximizeWindow()

'STEP - [병원관리자 로그인] 버튼 선택'
WebUI.click(findTestObject('병드민설정_세니티/btn_admin_login'), FailureHandling.CONTINUE_ON_FAILURE)

'STEP - ID 입력'
WebUI.sendKeys(findTestObject('병드민설정_세니티/input_id'), GlobalVariable.hospital_id, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - PW 입력'
WebUI.sendKeys(findTestObject('병드민설정_세니티/input_pw'), GlobalVariable.hospital_pw, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [병원관리자 로그인] 버튼 선택'
WebUI.click(findTestObject('병드민설정_세니티/btn_login'), FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 페이지 scale 적용'
WebUI.executeJavaScript("document.body.style.transform = 'scale(1.0)';", null)

'STEP - 홈 팝업 [닫기] 버튼 선택'
if(WebUI.waitForElementVisible(findTestObject('병드민설정_세니티/btn_close'), GlobalVariable.waitTime))
{
	WebUI.click(findTestObject('병드민설정_세니티/btn_close'), FailureHandling.CONTINUE_ON_FAILURE)
}

//접수 OFF
'STEP - 접수 OFF'
if(WebUI.waitForElementVisible(findTestObject('병드민설정_세니티/btn_receipt_setting'), GlobalVariable.waitTime))
{
	'STEP - [접수 설정] 버튼 선택'
	WebUI.click(findTestObject('병드민설정_세니티/btn_receipt_setting'), FailureHandling.CONTINUE_ON_FAILURE)
	
	'STEP - [똑닥 접수 사용중지] 버튼으로 스크롤 이동'
	WebUI.scrollToElement(findTestObject('병드민설정_세니티/btn_recept_unsubscribe'), GlobalVariable.waitTime, FailureHandling.CONTINUE_ON_FAILURE)
	
	'STEP - [똑닥 접수 사용중지] 버튼 선택'
	WebUI.click(findTestObject('병드민설정_세니티/btn_recept_unsubscribe'), FailureHandling.CONTINUE_ON_FAILURE)
	
	WebUI.delay(2)
	
	'STEP - [사용 중지] 버튼 선택'
	WebUI.click(findTestObject('병드민설정_세니티/btn_off'), FailureHandling.CONTINUE_ON_FAILURE)
	
	WebUI.delay(3)
	
	'STEP - [홈] 메뉴 선택'
	WebUI.click(findTestObject('병드민설정_세니티/btn_menu', [('text') : '홈']), FailureHandling.CONTINUE_ON_FAILURE)
}
	
//예약 ON
'STEP - 예약 ON'
if(WebUI.waitForElementVisible(findTestObject('병드민설정_세니티/btn_resrv_use'), GlobalVariable.waitTime))
{
	'STEP - [예약 사용하기] 버튼 선택'
	WebUI.click(findTestObject('병드민설정_세니티/btn_resrv_use'), FailureHandling.CONTINUE_ON_FAILURE)
	
	WebUI.delay(2)
	
	'STEP - [홈] 메뉴 선택'
	WebUI.click(findTestObject('병드민설정_세니티/btn_menu', [('text') : '홈']), FailureHandling.CONTINUE_ON_FAILURE)
}

'STEP - 홈 [예약 설정] 버튼 선택'
WebUI.click(findTestObject('병드민설정_세니티/btn_resrv_settings'), FailureHandling.CONTINUE_ON_FAILURE)

//예약 사전문진 ON
'STEP - "예약 사전문진" 타이틀로 이동'
WebUI.scrollToElement(findTestObject('병드민설정_세니티/txt_title', [('text') : '예약 사전문진']), GlobalVariable.waitTime, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(2)

'STEP - [설정하기] 버튼 선택'
WebUI.click(findTestObject('병드민설정_세니티/btn_reservQuestionSetting'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(2)

'STEP - Angular Frame 전환'
WebUI.switchToFrame(findTestObject('병드민설정_세니티/frame'), GlobalVariable.waitTime)

'STEP - 사전문진 사용 토글 컬러 저장'
toggle_color2 = WebUI.getCSSValue(findTestObject('병드민설정_세니티/btn_toggle'), 'color')

println(toggle_color2)

'STEP - 사전문진 사용 여부 ON'
if(toggle_color2  == 'rgba(184, 184, 184, 1)')
{
	'STEP - 토글 버튼 ON 선택'
	WebUI.click(findTestObject('병드민설정_세니티/btn_toggle'), FailureHandling.CONTINUE_ON_FAILURE)
	
	WebUI.delay(2)
	
	'STEP - [확인] 버튼 선택'
	WebUI.click(findTestObject('병드민설정_세니티/btn_accept'), FailureHandling.CONTINUE_ON_FAILURE)
	
	'STEP - [이전] 버튼 선택'
	WebUI.click(findTestObject('병드민설정_세니티/btn_prev'), FailureHandling.CONTINUE_ON_FAILURE)
	
	WebUI.delay(2)
	
	WebUI.refresh()
}
else
{
	'STEP - [이전] 버튼 선택'
	WebUI.click(findTestObject('병드민설정_세니티/btn_prev'), FailureHandling.CONTINUE_ON_FAILURE)
	
	WebUI.delay(2)
	
	WebUI.refresh()
}

'STEP - 페이지 scale 적용'
WebUI.executeJavaScript("document.body.style.transform = 'scale(1.0)';", null)

//영유아문진표 ON
'STEP - "더 똑똑하게 예약를 써보시겠어요" 타이틀로 이동'
WebUI.scrollToElement(findTestObject('병드민설정_세니티/txt_title', [('text') : '더 똑똑하게 예약를 써보시겠어요']), GlobalVariable.waitTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [병원 설정 보러가기] 버튼 선택'
WebUI.click(findTestObject('병드민설정_세니티/btn_hospitalSetting'), FailureHandling.CONTINUE_ON_FAILURE)

'STEP - "영유아검진 1차검진 예약" 타이틀로 이동'
WebUI.scrollToElement(findTestObject('병드민설정_세니티/txt_title', [('text') : '영유아검진 1차검진 예약']), GlobalVariable.waitTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 영유아검진 문진표 사용 여부 토글 컬러 저장'
toggle_color3 = WebUI.getCSSValue(findTestObject('병드민설정_세니티/btn_infantToggleTrue'), 'color')

println(toggle_color3)

'STEP - 영유아검진 문진표 사용 여부가 OFF인 경우 ON으로 변경 후 저장'
if(toggle_color3  == 'rgba(149, 155, 161, 1)')
{
	'STEP - 토글 버튼 ON 선택'
	WebUI.click(findTestObject('병드민설정_세니티/btn_infantToggleTrue'), FailureHandling.CONTINUE_ON_FAILURE)
	
	WebUI.delay(2)
}

//영유아검진 1차검진 예약가능 ON
'STEP - 영유아검진 1차검진 예약가능 사용 여부 토글 컬러 저장'
toggle_color = WebUI.getCSSValue(findTestObject('병드민설정_세니티/btn_infantToggleTrue_1'), 'color')

println(toggle_color)

'STEP - 영유아검진 1차검진 예약가능 사용 여부가 OFF인 경우 ON으로 변경 후 저장'
if(toggle_color  == 'rgba(149, 155, 161, 1)')
{
	'STEP - 토글 버튼 ON 선택'
	WebUI.click(findTestObject('병드민설정_세니티/btn_infantToggleTrue_1'), FailureHandling.CONTINUE_ON_FAILURE)

	WebUI.delay(2)
}

'STEP - 브라우저 종료'
WebUI.closeBrowser()
