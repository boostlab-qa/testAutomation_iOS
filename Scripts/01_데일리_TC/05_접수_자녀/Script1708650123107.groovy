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

// 실행할 CMD 명령어
def command = "adb shell screenrecord --time-limit 130 --output-format mp4 --size 1080x2640 --bit-rate 5000000 /sdcard/05_접수_자녀.mp4"

// 명령어 실행
def processBuilder = new ProcessBuilder(command.split())
def process = processBuilder.start()

'병드민 설정 테스트케이스 불러오기'
Mobile.callTestCase(findTestCase('00_병드민설정_데일리/01_병드민_데일리_02'), [:])

//접수 03 - 자녀로 직접결제 수단 사용하여 접수 신청
'STEP - 똑닥 앱 실행'
Mobile.startExistingApplication(GlobalVariable.appid)

'STEP - 홈 검색 영역 선택'
Mobile.tap(findTestObject('운영/03_홈/area_view_search_bar'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 병원 검색어 입력'
Mobile.setText(findTestObject('운영/07_검색/input_search'), GlobalVariable.hospital_name, GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [검색] 버튼 선택'
Mobile.tap(findTestObject('운영/07_검색/btn_search'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 검색 결과 첫번째 리스트 [+] 버튼 선택'
Mobile.tap(findTestObject('운영/07_검색/btn_result_plus'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 검색 결과 병원 선택'
Mobile.tap(findTestObject('운영/07_검색/txt_hospital_name'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [바로접수] 버튼 선택'
Mobile.tap(findTestObject('운영/08_병원상세/btn_large', [('text') : '바로접수']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 패널티 팝업이 노출되는 경우 [확인] 버튼 선택'
if(Mobile.waitForElementPresent(findTestObject('운영/09_접수/btn_panalty'), GlobalVariable.waitTime, FailureHandling.CONTINUE_ON_FAILURE))
{
Mobile.tap(findTestObject('운영/09_접수/btn_panalty'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
}

'STEP - 진료대상 자녀 이름 선택'
Mobile.tap(findTestObject('운영/09_접수/txt_name', [('text') : '영유아']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [다음] 버튼 선택'
Mobile.tap(findTestObject('운영/09_접수/btn_receiptBtn', [('text') : '다음']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 주민등록 뒷자리 미입력 상태인 경우 뒷자리 입력'
if(Mobile.waitForElementPresent(findTestObject('운영/09_접수/txt_transmission_title'), GlobalVariable.waitTime, FailureHandling.CONTINUE_ON_FAILURE) == true)
{
	'STEP - 주민번호 뒷자리 선택'
	Mobile.tap(findTestObject('운영/09_접수/input_back_number'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
	'STEP - 주민번호 뒷자리 "4444444" 입력'
	for(i = 1; i <= 7; i++)
	{
		Mobile.tap(findTestObject('운영/10_가족관리/btn_keypad_number', [('text') : '4']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	}
	
	Mobile.tap(findTestObject('운영/09_접수/btn_finish'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
}

'기대결과 - 진료실 정보에 대기 순서가 노출된다.'
Mobile.verifyElementVisible(findTestObject('운영/09_접수/txt_stateSubMemoTxt', [('text') : '바로 진료 가능']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 진료실 선택'
Mobile.tap(findTestObject('운영/09_접수/txt_name', [('text') : '진료실']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 진료실 공지 노출 시 팝업 닫기'
if(Mobile.waitForElementPresent(findTestObject('운영/00_공통/txt_tvConfirm'), GlobalVariable.waitTime, FailureHandling.CONTINUE_ON_FAILURE))
{
	'STEP - [확인] 버튼 선택'
	Mobile.tap(findTestObject('운영/00_공통/txt_tvConfirm'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
}

'STEP - 진료항목 선택'
Mobile.tap(findTestObject('운영/09_접수/txt_item', [('text') : '영유아검진']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 발생증상 선택'
Mobile.tap(findTestObject('운영/09_접수/tv_tvName', [('text') : '감기']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [다음] 버튼 선택'
Mobile.tap(findTestObject('운영/09_접수/btn_receiptBtn', [('text') : '다음']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - "결제수단 선택" 화면으로 이동된다.'
Mobile.verifyElementVisible(findTestObject('운영/09_접수/tv_tvPaymentListTitle', [('text') : '결제수단 선택']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [병원에서 직접결제] 버튼 선택'
Mobile.tap(findTestObject('운영/09_접수/btn_tvDirectTitle'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [다음] 버튼 선택'
Mobile.tap(findTestObject('운영/09_접수/btn_receiptBtn', [('text') : '다음']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [동의하고 접수하기] 버튼 선택'
Mobile.tap(findTestObject('운영/09_접수/btn_receiptBtn', [('text') : '동의하고 접수하기']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 홈 화면으로 이동된다.'
Mobile.verifyElementVisible(findTestObject('운영/03_홈/btn_menu_home_selected'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 개인화 영역이 노출된다.'
Mobile.verifyElementVisible(findTestObject('운영/03_홈/btn_cl_reception_card'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 개인화 영역 선택'
Mobile.tap(findTestObject('운영/03_홈/btn_cl_reception_card'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 진료내역 상세 화면으로 이동된다.'
Mobile.verifyElementVisible(findTestObject('운영/00_공통/txt_page_titleTxt', [('text') : '진료내역 상세']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 진료내역 상세 병원명이 노출된다.'
Mobile.verifyElementText(findTestObject('운영/04_접수내역/txt_detail_hospital'), GlobalVariable.hospital_name, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 진료내역 상세 진료실명이 노출된다.'
Mobile.verifyElementText(findTestObject('운영/04_접수내역/txt_office'), '진료실', FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 진료내역 상세 진료항목이 노출된다.'
Mobile.verifyElementVisible(findTestObject('운영/04_접수내역/tv_tvSymptomTxt', [('text') : '영유아검진']),  GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 진료내역 상세 발생증상이 노출된다.'
Mobile.verifyElementVisible(findTestObject('운영/04_접수내역/tv_tvSymptomListTxt', [('text') : '감기']),  GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 진료내역 상세 결제수단 정보가 노출된다.'
Mobile.verifyElementVisible(findTestObject('운영/04_접수내역/tv_methodValue', [('text') : '직접결제']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 접수 상태 문구 저장'
state = Mobile.getText(findTestObject('운영/04_접수내역/txt_stateTxt'), GlobalVariable.waitTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 접수 상태가 "진료 차례"가 아니면 대기'
if(state != '진료 차례')
{
	Mobile.delay(5)
}

'STEP - [접수취소] 버튼 선택'
Mobile.tap(findTestObject('운영/04_접수내역/btn_detail_receipt_cancel'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 확인 팝업 [접수취소] 버튼 선택'
Mobile.tap(findTestObject('운영/00_공통/btn_positiveTxt'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 진료내역 상세 [접수취소] 버튼이 노출되지 않는다.'
Mobile.verifyElementNotVisible(findTestObject('운영/04_접수내역/btn_detail_receipt_cancel'), GlobalVariable.waitTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 진료내역 상세 결제수단 정보가 노출되지 않는다.'
Mobile.verifyElementNotVisible(findTestObject('운영/04_접수내역/tv_methodValue', [('text') : '직접결제']), GlobalVariable.waitTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [<-] 뒤로가기 버튼 선택'
Mobile.tap(findTestObject('운영/00_공통/btn_backBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 홈 화면으로 이동된다.'
Mobile.verifyElementVisible(findTestObject('운영/03_홈/btn_menu_home_selected'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 홈 화면에 진료카드가 노출되지 않는다.'
Mobile.verifyElementNotVisible(findTestObject('운영/03_홈/btn_cl_reception_card'), GlobalVariable.waitTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 앱 종료'
try {
	AppiumDriver<?> driver = MobileDriverFactory.getDriver()
	driver.terminateApp(GlobalVariable.appid)

} catch (Exception e) {
}

// 실행 결과 확인
def reader = new BufferedReader(new InputStreamReader(process.inputStream))
def line
while ((line = reader.readLine()) != null) {
	println(line)
}