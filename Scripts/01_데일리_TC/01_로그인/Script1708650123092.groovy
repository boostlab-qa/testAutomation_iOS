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
def command = "adb shell screenrecord --time-limit 75 --output-format mp4 --size 1080x2640 --bit-rate 5000000 /sdcard/01_로그인.mp4"

// 명령어 실행
def processBuilder = new ProcessBuilder(command.split())
def process = processBuilder.start()

//이메일 로그인
'STEP - 똑닥 앱 실행'
Mobile.startExistingApplication(GlobalVariable.appid)

Mobile.delay(5)

'선택 업데이트 알림 팝업 노출 시 [닫기] 선택' //선택 업데이트 팝업
if (Mobile.waitForElementPresent(findTestObject('운영/00_공통/btn_negativeTxt'), GlobalVariable.waitTime))
{
		Mobile.tap(findTestObject('운영/00_공통/btn_negativeTxt'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
}

'카카오 전환 유도 팝업 노출 시 [오늘 하루 보지 않기] 버튼 선택' //카카오 전환 유도 팝업 예외처리
if (Mobile.waitForElementPresent(findTestObject('운영/03_홈/01_home_popup/btn_kakao_agree_skip'), GlobalVariable.waitTime))
{
		Mobile.tap(findTestObject('운영/03_홈/01_home_popup/btn_kakao_agree_skip'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
}

'맴버십 사전안내 팝업 노출 시 [오늘 그만 보기] 버튼 선택' //맴버십 사전 안내 팝업 예외처리
if (Mobile.waitForElementPresent(findTestObject('운영/03_홈/01_home_popup/btn_tv_not_show_today'), GlobalVariable.waitTime))
{
		Mobile.tap(findTestObject('운영/03_홈/01_home_popup/btn_tv_not_show_today'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
}

'마케팅 수신동의 팝업 노출 시 [좋아요] 선택' //홈 팝업 예외처리
if (Mobile.waitForElementPresent(findTestObject('운영/03_홈/01_home_popup/btn_maketing_common'), GlobalVariable.waitTime))
{
		Mobile.tap(findTestObject('운영/03_홈/01_home_popup/btn_maketing_common'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
}

'똑닥 어떠셨나요? 팝업 노출 시 [다시 보지 않기] 버튼 선택'
if (Mobile.waitForElementPresent(findTestObject('운영/03_홈/01_home_popup/btn_skip'), GlobalVariable.waitTime))
{
		Mobile.tap(findTestObject('운영/03_홈/01_home_popup/btn_skip'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
}

'STEP- [마이페이지] 메뉴 선택'
Mobile.tap(findTestObject('운영/03_홈/btn_menu_mypage'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 로그인 상태인 경우 로그아웃 진행'
if(Mobile.waitForElementPresent(findTestObject('운영/05_마이페이지/btn_optionalBtn'), GlobalVariable.waitTime))
{
	'STEP - [수정] 버튼 선택'
	Mobile.tap(findTestObject('운영/05_마이페이지/btn_optionalBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
	'STEP - [로그아웃] 버튼 선택'
	Mobile.tap(findTestObject('테스트/05_마이페이지/tv_title', [('text') : '로그아웃']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

	'STEP - [확인] 버튼 선택'
	Mobile.tap(findTestObject('테스트/05_마이페이지/tv_title', [('text') : '확인']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
	'STEP - 마이페이지 [로그인] 버튼 선택'
	Mobile.tap(findTestObject('운영/05_마이페이지/btn_login'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
}
else
{
	'STEP - 마이페이지 [로그인] 버튼 선택'
	Mobile.tap(findTestObject('운영/05_마이페이지/btn_login'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
}

'STEP - [이메일 로그인] 버튼 선택'
Mobile.tap(findTestObject('운영/01_온보딩/btn_tvEmailLoginBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 이메일 id 입력'
Mobile.setText(findTestObject('운영/02_로그인/input_etEmail'), GlobalVariable.email_id, GlobalVariable.fixedTime)

'STEP - 이메일 password 입력'
Mobile.setText(findTestObject('운영/02_로그인/input_etPassword'), GlobalVariable.email_password, GlobalVariable.fixedTime)

'STEP - [로그인하기] 버튼 선택'
Mobile.tap(findTestObject('운영/02_로그인/btn_tvLoginConfirm'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'카카오 전환 유도 팝업 노출 시 [오늘 하루 보지 않기] 버튼 선택'
if (Mobile.waitForElementPresent(findTestObject('운영/03_홈/01_home_popup/btn_kakao_agree_skip'), GlobalVariable.waitTime))
{
		Mobile.tap(findTestObject('운영/03_홈/01_home_popup/btn_kakao_agree_skip'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
}

'기대결과 - 마이페이지에 유저 이름이 노출된다.'
Mobile.verifyElementVisible(findTestObject('운영/05_마이페이지/txt_name_title', [('text') : GlobalVariable.user_name]), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 마이페이지에 [수정] 버튼이 노출된다.'
Mobile.verifyElementVisible(findTestObject('운영/05_마이페이지/btn_optionalBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 홈 메뉴 선택'
Mobile.tap(findTestObject('운영/03_홈/btn_menu_home'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

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