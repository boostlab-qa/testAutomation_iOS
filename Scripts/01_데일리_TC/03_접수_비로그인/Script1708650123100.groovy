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
def command = "adb shell screenrecord --time-limit 115 --output-format mp4 --size 1080x2640 --bit-rate 5000000 /sdcard/03_접수_비로그인.mp4"

// 명령어 실행
def processBuilder = new ProcessBuilder(command.split())
def process = processBuilder.start()

'병드민 설정 테스트케이스 불러오기'
Mobile.callTestCase(findTestCase('00_병드민설정_데일리/01_병드민_데일리_01'), [:])

'STEP - 똑닥 앱 실행'
Mobile.startExistingApplication(GlobalVariable.appid)

'STEP- [마이페이지] 메뉴 선택'
Mobile.tap(findTestObject('운영/03_홈/btn_menu_mypage'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP- 로그인 상태인 경우 로그아웃'
if (Mobile.waitForElementPresent(findTestObject('운영/05_마이페이지/btn_optionalBtn'), GlobalVariable.waitTime))
{
		'STEP- [수정] 버튼 선택'
		Mobile.tap(findTestObject('운영/05_마이페이지/btn_optionalBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
		
		'STEP - [로그아웃] 버튼 선택'
		Mobile.tap(findTestObject('테스트/05_마이페이지/tv_title', [('text') : '로그아웃']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

		'STEP - [확인] 버튼 선택'
		Mobile.tap(findTestObject('테스트/05_마이페이지/tv_title', [('text') : '확인']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
}

'STEP- [홈] 메뉴 선택'
Mobile.tap(findTestObject('운영/03_홈/btn_menu_home'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 홈 검색 영역 선택'
Mobile.tap(findTestObject('운영/03_홈/area_view_search_bar'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

Mobile.delay(3)

'STEP - 병원 검색어 입력'
Mobile.setText(findTestObject('운영/07_검색/input_search'), GlobalVariable.hospital_name, GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [검색] 버튼 선택'
Mobile.tap(findTestObject('운영/07_검색/btn_search'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 검색 결과 첫번째 리스트 [+] 버튼 선택'
Mobile.tap(findTestObject('운영/07_검색/btn_result_plus'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 검색 결과 병원 선택'
Mobile.tap(findTestObject('운영/07_검색/txt_hospital_name'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 병원상세로 이동되고, [바로접수] 버튼이 노출된다.'
Mobile.verifyElementVisible(findTestObject('운영/08_병원상세/btn_left', [('text') : '바로접수']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - [시간예약] 버튼이 노출된다.'
Mobile.verifyElementVisible(findTestObject('운영/08_병원상세/btn_right', [('text') : '시간예약']), GlobalVariable.waitTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [바로접수] 버튼 선택'
Mobile.tap(findTestObject('운영/08_병원상세/btn_left', [('text') : '바로접수']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 로그인 유도 바텀시트가 노출된다.'
Mobile.verifyElementVisible(findTestObject('운영/02_로그인/btn_commonBtnTitle', [('text') : '카카오로 시작하기']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [다음에 하기] 버튼 선택'
Mobile.tap(findTestObject('운영/02_로그인/tv_cancel'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 로그인 유도 바텀시트가 비노출된다.'
Mobile.verifyElementNotVisible(findTestObject('운영/02_로그인/btn_commonBtnTitle', [('text') : '카카오로 시작하기']), GlobalVariable.waitTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [<-] 병원상세 화면에서 버튼 선택'
Mobile.tap(findTestObject('운영/08_병원상세/btn_iv_back'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [<-] 검색 화면에서 버튼 선택'
Mobile.tap(findTestObject('운영/07_검색/btn_backBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

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