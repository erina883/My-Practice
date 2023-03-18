package com.erina.mypractice

import android.graphics.Bitmap
import android.os.Bundle
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.erina.mypractice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    private lateinit var listViewAdapter: ExpandableListViewAdapter
    private lateinit var chapterList: List<String>
    private lateinit var topicList: HashMap<String, List<String>>
    private var topicDetails = HashMap<String, String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showList()

        listViewAdapter = ExpandableListViewAdapter(this, chapterList, topicList, topicDetails)

        binding.eListView.setAdapter(listViewAdapter)

    }

        private fun showList() {
            chapterList = ArrayList()
            topicList = HashMap()

            topicDetails = HashMap()

            (chapterList as ArrayList<String>).add("সহীহ বুখারী - ১ম খণ্ড")
            (chapterList as ArrayList<String>).add("সহীহ বুখারী - ২য় খণ্ড")
            (chapterList as ArrayList<String>).add("সহীহ বুখারী - ৩য় খণ্ড")
            (chapterList as ArrayList<String>).add("সহীহ বুখারী - ৪র্থ খণ্ড")
            (chapterList as ArrayList<String>).add("সহীহ বুখারী - ৫ম খণ্ড")
            (chapterList as ArrayList<String>).add("সহীহ বুখারী - ৬ষ্ঠ খণ্ড")
            (chapterList as ArrayList<String>).add("সহীহ বুখারী - ৭ম খণ্ড")
            (chapterList as ArrayList<String>).add("সহীহ বুখারী - ৮ম খণ্ড")
            (chapterList as ArrayList<String>).add("সহীহ বুখারী - ৯ম খণ্ড")
            (chapterList as ArrayList<String>).add("সহীহ বুখারী - ১০ম খণ্ড")

            val topic1: MutableList<String> = ArrayList()
            topic1.add("১/ ওহীর সূচনা (كتاب بدء الوحى)")
            topic1.add("২/ ঈমান (كتاب الإيمان)")
            topic1.add("৩/ ইলম বা জ্ঞান (كتاب العلم)")
            topic1.add("৪/ উযূ (كتاب الوضوء)")
            topic1.add("৫/ গোসল (كتاب الغسل)")
            topic1.add("৬/ হায়য (كتاب الحيض)")
            topic1.add("৭/ তায়াম্মুম (كتاب التيمم)")
            topic1.add("৮/ সালাত (كتاب الصلاة)")

            topicDetails["১/ ওহীর সূচনা (كتاب بدء الوحى)"] = "topic1.pdf"
            topicDetails["২/ ঈমান (كتاب الإيمان)"] = "topic2.pdf"
            topicDetails["৩/ ইলম বা জ্ঞান (كتاب العلم)"] = "topic3.pdf"

            val topic2: MutableList<String> = ArrayList()
            topic2.add("৯/ সালাতের সময়সমূহ (كتاب مواقيت الصلاة)")
            topic2.add("১০/ আযান (كتاب الأذان)")
            topic2.add("১১/ জুমু‘আহ (كتاب الجمعة)")
            topic2.add("১২/ খাওফ (শত্রুভীতির অবস্থায় সালাত) (كتاب صلاة الخوف)")
            topic2.add("১৩/ দুই’ঈদ (كتاب العيدين)")
            topic2.add("১৪/ বিতর (كتاب الوتر)")
            topic2.add("১৬/ সূর্যগ্রহণ (كتاب الكسوف)")
            topic2.add("১৭/ কুরআন তিলাওয়াতের সিজদা্ (كتاب سجود القرآن)")
            topic2.add("১৮/ সালাত ক্বাসর করা (كتاب التقصير)")
            topic2.add("১৯/ তাহাজ্জুদ (كتاب التهجد)")
            topic2.add("২০/ মক্কাহ ও মদীনাহর মসজিদে সালাতের মর্যাদা (كتاب فضل الصلاة فى مسجد مكة والمدينة)")
            topic2.add("২১/ সালাতের সাথে সংশ্লিষ্ট কাজ (كتاب العمل فى الصلاة)")
            topic2.add("২২/ সাহু সিজদা (كتاب السهو)")
            topic2.add("২৩/ জানাযা (كتاب الجنائز)")

            val topic3: MutableList<String> = ArrayList()
            topic3.add("২৪/ যাকাত (كتاب الزكاة)")
            topic3.add("২৫/ হাজ্জ (হজ্জ/হজ) (كتاب الحج)")
            topic3.add("২৬/ উমরাহ (كتاب العمرة)")
            topic3.add("২৭/ পথে আটকে পড়া ও ইহরাম অবস্থায় শিকারকারীর বিধান (كتاب المحصر)")
            topic3.add("২৮/ ইহরাম অবস্থায় শিকার এবং অনুরূপ কিছুর বদলা (كتاب جزاء الصيد)")
            topic3.add("২৯/ মদীনার ফাযীলাত (كتاب فضائل المدينة)")
            topic3.add("৩০/ সাওম/রোযা (كتاب الصوم)")
            topic3.add("৩১/ তারাবীহর সালাত (كتاب صلاة التراويح)")
            topic3.add("৩২/ লাইলাতুল কদর-এর ফযীলত (كتاب فضل ليلة القدر)")
            topic3.add("৩৩/ ই‘তিকাফ (كتاب الاعتكاف)")

            val topic4: MutableList<String> = ArrayList()
            topic4.add("৩৪/ ক্রয়-বিক্রয় (كتاب البيوع)")
            topic4.add("৩৫/ সলম (অগ্রিম ক্রয়-বিক্রয়) (كتاب السلم)")
            topic4.add("৩৬/ শুফ্‘আহ (كتاب الشفعة)")
            topic4.add("৩৭/ ইজারা (كتاب الإجارة)")
            topic4.add("৩৮/ হাওয়ালাত (ঋণ আদায়ের দায়িত্ব গ্রহণ করা) (كتاب الحوالات)")
            topic4.add("৩৯/ যামিন হওয়া (كتاب الكفالة)")
            topic4.add("৪০/ ওয়াকালাহ (প্রতিনিধিত্ব) (كتاب الوكالة)")
            topic4.add("৪১/ চাষাবাদ (كتاب المزارعة)")
            topic4.add("৪২/ পানি সেচ (كتاب المساقاة)")
            topic4.add("৪৩/ ঋণ গ্রহণ, ঋণ পরিশোধ, নিষেধাজ্ঞা আরোপ ও দেউলিয়া ঘোষণা (كتاب فى الاستقراض)")
            topic4.add("৪৪/ ঝগড়া-বিবাদ মীমাংসা (كتاب الخصومات)")
            topic4.add("৪৫/ পড়ে থাকা জিনিস উঠিয়ে নেয়া (كتاب فى اللقطة)")
            topic4.add("৪৬/ অত্যাচার, কিসাস ও লুণ্ঠন (كتاب المظالم)")
            topic4.add("৪৭/ অংশীদারিত্ব (كتاب الشركة)")
            topic4.add("৪৮/ বন্ধক (كتاب الرهن)")
            topic4.add("৪৯/ ক্রীতদাস আযাদ করা (كتاب العتق)")
            topic4.add("৫০/ চুক্তিবদ্ধ দাসের বর্ণনা (كتاب المكاتب)")
            topic4.add("৫১/ হিবা ও এর ফযীলত (كتاب الهبة وفضلها والتحريض عليها)")
            topic4.add("৫২/ সাক্ষ্যদান (كتاب الشهادات)")


            val topic5: MutableList<String> = ArrayList()
            topic5.add("৫৩/ বিবাদ মীমাংসা (كتاب الصلح)")
            topic5.add("৫৪/ শর্তাবলী (كتاب الشروط)")
            topic5.add("৫৫/ ওয়াসিয়াত (كتاب الوصايا)")
            topic5.add("৫৬/ জিহাদ ও যুদ্ধকালীন আচার ব্যবহার (كتاب الجهاد والسير)")
            topic5.add("৫৭/ খুমুস (এক পঞ্চমাংশ) (كتاب فرض الخمس)")
            topic5.add("৫৮/ জিযিয়াহ্ কর ও সন্ধি স্থাপন (كتاب الجزية والموادعة)")
            topic5.add("৫৯/ সৃষ্টির সূচনা (كتاب بدء الخلق)")

            val topic6: MutableList<String> = ArrayList()
            topic6.add("৬০/ আম্বিয়া কিরাম ('আঃ) (كتاب أحاديث الأنبياء)")
            topic6.add("৬১/ মর্যাদা ও বৈশিষ্ট্য (كتاب المناقب)")
            topic6.add("৬২/ সাহাবীগণ [রাযিয়াল্লাহ ‘আনহুম]-এর মর্যাদা (كتاب فضائل أصحاب النبى ﷺ)")
            topic6.add("৬৩/ আনসারগণ [রাযিয়াল্লাহু ‘আনহুম]-এর মর্যাদা (كتاب مناقب الأنصار)")
            topic6.add("৬৪/ মাগাযী [যুদ্ধ] (كتاب المغازى)")

            val topic7: MutableList<String> = ArrayList()
            topic7.add("৬৫/ কুরআন মাজীদের তাফসীর (كتاب التفسير)")

            val topic8: MutableList<String> = ArrayList()
            topic8.add("৬৬/ আল-কুরআনের ফাযীলাতসমূহ (كتاب فضائل القرآن)")
            topic8.add("৬৭/ বিয়ে (كتاب النكاح)")

            val topic9: MutableList<String> = ArrayList()
            topic9.add("৬৯/ ভরণ-পোষণ (كتاب النفقات)")
            topic9.add("৭০/ খাওয়া সংক্রান্ত (كتاب الأطعمة)")
            topic9.add("৭১/ আক্বীক্বাহ (كتاب العقيقة)")
            topic9.add("৭২/ যবহ ও শিকার (كتاب الذبائح والصيد )")
            topic9.add("৭৩/ কুরবানী (كتاب الأضاحي)")
            topic9.add("৭৪/ পানীয় (كتاب الأشربة)")
            topic9.add("৭৫/ রুগী (كتاب المرضى)")
            topic9.add("৭৬/ চিকিৎসা (كتاب الطب)")
            topic9.add("৭৭/ পোশাক (كتاب اللباس)")
            topic9.add("৭৮/ আচার-ব্যবহার (كتاب الأدب)")
            topic9.add("৭৯/ অনুমতি প্রার্থনা (كتاب الاستئذان)")
            topic9.add("৮০/ দু‘আসমূহ (كتاب الدعوات)")

            val topic10: MutableList<String> = ArrayList()
            topic10.add("৮১/ সদয় হওয়া (كتاب الرقاق)")
            topic10.add("৮২/ তাকদীর (كتاب القدر)")
            topic10.add("৮৩/ শপথ ও মানত (كتاب الأيمان والنذور)")
            topic10.add("৮৪/ শপথের কাফফারাসমূহ (كتاب كفارات الأيمان)")
            topic10.add("৮৫/ ফারায়িয (كتاب الفرائض)")
            topic10.add("৮৬/ দন্ডবিধি (كتاب الحدود)")
            topic10.add("৮৭/ রক্তপণ (كتاب الديات)")
            topic10.add("৮৮/ আল্লাহদ্রোহী ও ধর্মত্যাগীদেরকে তাওবাহর প্রতি আহবান ও তাদের সঙ্গে যুদ্ধ করা (كتاب استتابة المرتدين والمعاندين وقتالهم)")
            topic10.add("৮৯/ বল প্রয়োগের মাধ্যমে বাধ্য করা (كتاب الإكراه)")
            topic10.add("৯০/ কূটচাল অবলম্বন (كتاب الحيل)")
            topic10.add("৯১/ স্বপ্নের ব্যাখ্যা করা (كتاب التعبير)")
            topic10.add("৯২/ ফিতনা (كتاب الفتن)")
            topic10.add("৯৩/ আহ্কাম (كتاب الأحكام)")
            topic10.add("৯৪/ কামনা (كتاب التمنى)")
            topic10.add("৯৫/ 'খবরে ওয়াহিদ' গ্রহণযোগ্য (كتاب أخبار الآحاد)")
            topic10.add("৯৬/ কুরআন ও সুন্নাহকে শক্তভাবে ধরে থাকা (كتاب الاعتصام بالكتاب والسنة)")
            topic10.add("৯৭/ তাওহীদ (كتاب التوحيد)")

            topicList[chapterList[0]] = topic1
            topicList[chapterList[1]] = topic2
            topicList[chapterList[2]] = topic3
            topicList[chapterList[3]] = topic4
            topicList[chapterList[4]] = topic5
            topicList[chapterList[5]] = topic6
            topicList[chapterList[6]] = topic7
            topicList[chapterList[7]] = topic8
            topicList[chapterList[8]] = topic9
            topicList[chapterList[9]] = topic10


    }
}