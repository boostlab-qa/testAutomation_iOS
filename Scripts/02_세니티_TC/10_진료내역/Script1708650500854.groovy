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

//STEP01 - 진료내역이 없는 계정 확인
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
Mobile.setText(findTestObject('테스트/02_로그인/input_etEmail'), GlobalVariable.id_90001, GlobalVariable.fixedTime)

'STEP - 이메일 password 입력'
Mobile.setText(findTestObject('테스트/02_로그인/input_etPassword'), GlobalVariable.pw, GlobalVariable.fixedTime)

'STEP - [로그인하기] 버튼 선택'
Mobile.tap(findTestObject('테스트/02_로그인/btn_tvLoginConfirm'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 카카오 전환 유도 팝업 노출 시 [오늘 하루 보지 않기] 버튼 선택'
if (Mobile.waitForElementPresent(findTestObject('테스트/03_홈/01_home_popup/btn_kakao_agree_skip'), GlobalVariable.waitTime))
{
		Mobile.tap(findTestObject('테스트/03_홈/01_home_popup/btn_kakao_agree_skip'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
}

'STEP - 마이페이지에서 진료내역 메뉴 선택'
Mobile.tap(findTestObject('테스트/05_마이페이지/btn_tv_medical_record_title'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 진료내역 화면으로 이동된다.'
Mobile.verifyElementVisible(findTestObject('테스트/04_접수내역/txt_titleTxt', [('text') : '진료내역']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [진료받으러 가기] 버튼 선택'
Mobile.tap(findTestObject('테스트/04_접수내역/btn_commonBtnTitle', [('text') : '진료받으러 가기']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 홈 화면으로 이동된다.'
Mobile.verifyElementVisible(findTestObject('테스트/03_홈/btn_menu_home_selected'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
//

//STEP02 - 진료내역 목록이 있는 계정 확인
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

'STEP - 마이페이지에서 진료내역 메뉴 선택'
Mobile.tap(findTestObject('테스트/05_마이페이지/btn_tv_medical_record_title'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 진료내역 화면으로 이동된다.'
Mobile.verifyElementVisible(findTestObject('테스트/04_접수내역/txt_titleTxt', [('text') : '진료내역']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 진료내역 목록이 노출된다.'
Mobile.verifyElementVisible(findTestObject('테스트/04_접수내역/txt_tvHospitalTitle'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
//

//STEP03 - 진료내역 화면 필터 동작 확인
'STEP - [전체대상] 필터 선택'
Mobile.tap(findTestObject('테스트/04_접수내역/btn_filter', [('text') : '전체대상']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 진료대상 필터가 노출된다.'
Mobile.verifyElementVisible(findTestObject('테스트/00_공통/txt_class_text_view', [('text'): '진료대상 필터']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 본인 필터 선택'
Mobile.tap(findTestObject('테스트/04_접수내역/txt_family_filter', [('text') : GlobalVariable.name_main]), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [확인] 버튼 선택'
Mobile.tap(findTestObject('테스트/00_공통/txt_class_text_view', [('text'): '확인']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 진료내역 목록이 노출된다.'
Mobile.verifyElementVisible(findTestObject('테스트/04_접수내역/txt_tvHospitalTitle'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 진료내역 화면에 본인 이름 목록이 노출된다.'
Mobile.verifyElementVisible(findTestObject('테스트/04_접수내역/txt_tv_reception_user_name', [('text') : GlobalVariable.name_main]), GlobalVariable.waitTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 자녀 이름 목록이 노출되지 않는다.'
Mobile.verifyElementNotVisible(findTestObject('테스트/04_접수내역/txt_reception_name', [('text') : '영유아']), GlobalVariable.waitTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 대상 [본인] 필터 선택'
Mobile.tap(findTestObject('테스트/04_접수내역/btn_filter', [('text') : GlobalVariable.name_main]), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 진료대상 필터에서 자녀 선택'
Mobile.tap(findTestObject('테스트/04_접수내역/txt_family_filter', [('text') : '영유아']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [확인] 버튼 선택'
Mobile.tap(findTestObject('테스트/00_공통/txt_class_text_view', [('text'): '확인']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 진료내역 목록이 노출된다.'
Mobile.verifyElementVisible(findTestObject('테스트/04_접수내역/txt_tvHospitalTitle'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 진료내역 화면에 자녀 이름이 노출된다.'
Mobile.verifyElementVisible(findTestObject('테스트/04_접수내역/txt_reception_name', [('text') : '영유아']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 진료내역 화면 자녀 이름 우측에 본인 이름이 노출된다.'
Mobile.verifyElementVisible(findTestObject('테스트/04_접수내역/txt_user_name', [('text') : GlobalVariable.name_main]), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) 
//

//STEP04 - 진료내역 병원 목록 선택
'STEP - 병원 목록 선택'
Mobile.tap(findTestObject('테스트/04_접수내역/txt_hospital_name'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 진료내역 상세 화면으로 이동된다.'
Mobile.verifyElementVisible(findTestObject('테스트/04_접수내역/txt_titleTxt', [('text') : '진료내역 상세']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 진료내역 상세 화면에서 [<-] 이전 버튼 선택'
Mobile.tap(findTestObject('테스트/00_공통/btn_backBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 진료내역 화면으로 이동된다.'
Mobile.verifyElementVisible(findTestObject('테스트/04_접수내역/txt_titleTxt', [('text') : '진료내역']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
//

//STEP05 - 리뷰 관리 화면 동작 확인
'STEP - 진료내역 화면에서 [리뷰 관리] 버튼 선택'
Mobile.tap(findTestObject('테스트/04_접수내역/btn_tvOption'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 리뷰 관리 화면으로 이동된다.'
Mobile.verifyElementVisible(findTestObject('테스트/04_접수내역/txt_titleTxt', [('text') : '리뷰 관리']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 리뷰 목록이 노출된다.'
Mobile.verifyElementVisible(findTestObject('테스트/04_접수내역/area_rvReviewList'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 리뷰 목록에 병원명이 노출된다.'
Mobile.verifyElementVisible(findTestObject('테스트/04_접수내역/txt_tvReviewHospitalTitle'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 병원명 저장'
hospitalName = Mobile.getText(findTestObject('테스트/04_접수내역/txt_tvReviewHospitalTitle'), GlobalVariable.waitTime)

'STEP - 병원 목록 선택'
Mobile.tap(findTestObject('테스트/04_접수내역/txt_tvReviewHospitalTitle'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 병원 상세 화면으로 이동된다.'
Mobile.verifyElementVisible(findTestObject('테스트/08_병원상세/txt_tv_title', [('text') : hospitalName]), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 병원상세 화면에서 [<-] 뒤로가기 버튼 선택'
Mobile.tap(findTestObject('테스트/08_병원상세/btn_iv_back'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 리뷰 관리 화면으로 이동된다.'
Mobile.verifyElementVisible(findTestObject('테스트/04_접수내역/txt_titleTxt', [('text') : '리뷰 관리']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 리뷰 관리 화면에서 [<-] 뒤로가기 버튼 선택'
Mobile.tap(findTestObject('테스트/00_공통/btn_backBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 진료내역 화면으로 이동된다.'
Mobile.verifyElementVisible(findTestObject('테스트/04_접수내역/txt_titleTxt', [('text') : '진료내역']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
//

'STEP - 앱 종료'
try {
	AppiumDriver<?> driver = MobileDriverFactory.getDriver()
	driver.terminateApp(GlobalVariable.appid)

} catch (Exception e) {
}