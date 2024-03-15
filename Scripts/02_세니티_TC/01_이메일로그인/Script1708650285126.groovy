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


//똑닥 앱 데이터 삭제
'데이터삭제 테스트케이스 불러오기'
Mobile.callTestCase(findTestCase('02_세니티_TC/Scenario_00 데이터삭제/00_데이터삭제'), [:])
//

//STEP01 - 온보딩 화면에서 [둘러보기] 버튼 선택
'STEP - 똑닥 앱 실행'
Mobile.startExistingApplication(GlobalVariable.appid)

'STEP - 똑닥 권한안내 화면 [확인] 버튼 선택'
Mobile.tap(findTestObject('테스트/00_공통/btn_confirmBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 알림팝업 > [허용] 버튼 선택'
Mobile.tap(findTestObject('테스트/01_온보딩/btn_permission_allow'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 위치정보 액세스 팝업 > [앱 사용 중에만 허용] 버튼 선택'
Mobile.tap(findTestObject('테스트/01_온보딩/btn_permission_location_allow_foreground_only'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 전화 허용 팝업 > [허용] 버튼 선택'
Mobile.tap(findTestObject('테스트/01_온보딩/btn_permission_allow'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 온보딩 화면 [둘러보기] 버튼 선택'
Mobile.tap(findTestObject('테스트/01_온보딩/btn_tvSkipTitle'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'마케팅 수신동의 팝업 노출 시 [좋아요] 선택' 
if (Mobile.waitForElementPresent(findTestObject('테스트/03_홈/01_home_popup/btn_maketing_common'), GlobalVariable.waitTime))
{
		Mobile.tap(findTestObject('테스트/03_홈/01_home_popup/btn_maketing_common'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
}

'홈 팝업 노출 시 [오늘 그만 보기] 선택'  //예외처리
if (Mobile.waitForElementPresent(findTestObject('테스트/03_홈/01_home_popup/btn_tv_not_show_today'), GlobalVariable.waitTime))
{
		Mobile.tap(findTestObject('테스트/03_홈/01_home_popup/btn_tv_not_show_today'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
}

'기대결과 - 홈 화면으로 이동된다.'
Mobile.verifyElementVisible(findTestObject('테스트/03_홈/btn_menu_home'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) 
//

//STEP02 - 로그인 화면과 마이페이지간 화면 이동
'STEP- [마이페이지] 메뉴 선택'
Mobile.tap(findTestObject('테스트/03_홈/btn_menu_mypage'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 마이페이지 [로그인] 버튼 선택'
Mobile.tap(findTestObject('테스트/05_마이페이지/btn_login'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 로그인 화면에 [이메일 로그인] 버튼이 노출된다.'
Mobile.verifyElementVisible(findTestObject('테스트/02_로그인/btn_tvEmailLoginBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 로그인 화면에 [카카오로 시작하기] 버튼이 노출된다.'
Mobile.verifyElementVisible(findTestObject('테스트/02_로그인/btn_tvKakaoLoginBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 로그인 화면 [x] 버튼 선택'
Mobile.tap(findTestObject('테스트/02_로그인/btn_ivClose'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 마이페이지로 이동된다.'
Mobile.verifyElementVisible(findTestObject('테스트/05_마이페이지/btn_login'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
//

//STEP03 - 마이페이지에서 이메일 로그인
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

'기대결과 - 마이페이지에 사용자 이름이 노출된다.'
Mobile.verifyElementVisible(findTestObject('테스트/05_마이페이지/tv_toolbarTitle', [('text') : GlobalVariable.name_main]), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 마이페이지에 [수정] 버튼이 노출된다.'
Mobile.verifyElementVisible(findTestObject('테스트/05_마이페이지/btn_optionalBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
//

//STEP04 - 마이페이지에서 로그아웃
'STEP - 마이페이지 [수정] 버튼 선택'
Mobile.tap(findTestObject('테스트/05_마이페이지/btn_optionalBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [로그아웃] 버튼 선택'
Mobile.tap(findTestObject('테스트/05_마이페이지/tv_title', [('text') : '로그아웃']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [확인] 버튼 선택'
Mobile.tap(findTestObject('테스트/05_마이페이지/tv_title', [('text') : '확인']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 마이페이지에 [로그인] 버튼이 노출된다.'
Mobile.verifyElementVisible(findTestObject('테스트/05_마이페이지/btn_login'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 마이페이지 타이틀이 노출된다.'
Mobile.verifyElementVisible(findTestObject('테스트/05_마이페이지/tv_toolbarTitle', [('text') :'마이페이지']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
//

'STEP - 앱 종료'
try {
	AppiumDriver<?> driver = MobileDriverFactory.getDriver()
	driver.terminateApp(GlobalVariable.appid)

} catch (Exception e) {
}