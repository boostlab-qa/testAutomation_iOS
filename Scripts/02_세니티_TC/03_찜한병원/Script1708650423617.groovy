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

//STEP01 - 병원 즐겨찾기 등록하고 찜한 병원 화면 목록 확인
'STEP - 똑닥 앱 실행'
Mobile.startExistingApplication(GlobalVariable.appid)

'STEP - 홈 화면 찜한 병원 [☆] 버튼 선택'
Mobile.tap(findTestObject('테스트/03_홈/btn_iv_favorite'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 찜한 병원 화면으로 이동된다.'
Mobile.verifyElementVisible(findTestObject('테스트/05_마이페이지/txt_tv_title', [('text') : '찜한 병원']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) 

'STEP - 찜한 병원이 있는경우 즐겨찾기 해제'
if(Mobile.waitForElementPresent(findTestObject('테스트/05_마이페이지/txt_hospital_name', [('text') : GlobalVariable.hospital_name]), GlobalVariable.waitTime, FailureHandling.CONTINUE_ON_FAILURE))
{
	'STEP - 병원 목록 선택'
	Mobile.tap(findTestObject('테스트/05_마이페이지/txt_hospital_name', [('text') : GlobalVariable.hospital_name]), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
	'STEP - 병원상세 화면에서 [☆] 즐겨찾기 버튼 선택(해제)'
	Mobile.tap(findTestObject('테스트/03_홈/btn_iv_favorite'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
	Mobile.delay(2)
	
	'STEP - 병원상세 화면에서 [<-] 뒤로가기 버튼 선택'
	Mobile.tap(findTestObject('테스트/08_병원상세/btn_iv_back'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
}

'STEP - 찜한 병원 화면에서 뒤로가기 [<-] 버튼 선택'
Mobile.tap(findTestObject('테스트/08_병원상세/btn_iv_back'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 홈 화면에서 검색 영역 선택'
Mobile.tap(findTestObject('테스트/03_홈/area_view_search_bar'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 검색 화면에서 병원명 입력'
Mobile.setText(findTestObject('테스트/07_검색/input_search'), GlobalVariable.hospital_name, GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [검색] 버튼 선택'
Mobile.tap(findTestObject('테스트/07_검색/btn_search'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 검색 결과 첫번째 리스트 [+] 버튼 선택'
Mobile.tap(findTestObject('테스트/07_검색/btn_result_plus'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 검색 결과 병원명 선택'
Mobile.tap(findTestObject('테스트/07_검색/txt_hospital_name'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 병원상세 화면에서 [☆] 즐겨찾기 버튼 선택'
Mobile.tap(findTestObject('테스트/03_홈/btn_iv_favorite'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

Mobile.delay(2)

'STEP - 병원상세 화면에서 [<-] 뒤로가기 버튼 선택'
Mobile.tap(findTestObject('테스트/08_병원상세/btn_iv_back'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 검색 화면에서 [<-] 뒤로가기 버튼 선택'
Mobile.tap(findTestObject('테스트/00_공통/btn_backBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 홈 화면으로 이동된다.'
Mobile.verifyElementVisible(findTestObject('테스트/03_홈/btn_menu_home_selected'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) 

'STEP - 홈 화면에서 [☆] 찜한 병원 버튼 선택'
Mobile.tap(findTestObject('테스트/03_홈/btn_iv_favorite'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 찜한 병원 화면으로 이동된다.'
Mobile.verifyElementVisible(findTestObject('테스트/05_마이페이지/txt_tv_title', [('text') : '찜한 병원']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) 

Mobile.delay(3)

'기대결과 - 찜한 병원 화면에 즐겨찾기 등록한 병원 목록이 노출된다.'
Mobile.verifyElementVisible(findTestObject('테스트/05_마이페이지/txt_hospital_name', [('text') : GlobalVariable.hospital_name]), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
//

//STEP02 - 병원 즐겨찾기 해제하고 찜한 병원 화면 목록 확인
'STEP - 찜한목록 리스트 선택'
Mobile.tap(findTestObject('테스트/05_마이페이지/txt_hospital_name', [('text') : GlobalVariable.hospital_name]), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
'STEP - [☆]  즐겨찾기 버튼 선택(해제)'
Mobile.tap(findTestObject('테스트/03_홈/btn_iv_favorite'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

Mobile.delay(2)
	
'STEP - 병원상세 뒤로가기 [<-] 버튼 선택'
Mobile.tap(findTestObject('테스트/08_병원상세/btn_iv_back'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

Mobile.delay(3)

'기대결과 - 찜한 병원 화면으로 이동된다.' 
Mobile.verifyElementVisible(findTestObject('테스트/05_마이페이지/txt_tv_title', [('text') : '찜한 병원']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) 

'기대결과 - 찜한 병원 화면에 즐겨찾기 해제한 병원이 노출되지 않는다.'
Mobile.verifyElementNotVisible(findTestObject('테스트/05_마이페이지/txt_hospital_name', [('text') : GlobalVariable.hospital_name]), GlobalVariable.waitTime, FailureHandling.CONTINUE_ON_FAILURE)
//

'STEP - 앱 종료'
try {
	AppiumDriver<?> driver = MobileDriverFactory.getDriver()
	driver.terminateApp(GlobalVariable.appid)

} catch (Exception e) {
}