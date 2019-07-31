<?xml version="1.0"?>
<recipe>
    <instantiate from="src/app_package/ViewModel.kt.ftl"
                   to="${escapeXmlAttribute(srcOut)}/${className}ViewModel.kt" />
    <instantiate from="src/app_package/Fragment.kt.ftl"
                   to="${escapeXmlAttribute(srcOut)}/${className}Fragment.kt" />
    <instantiate from="res/layout/fragment.xml.ftl"
                   to="${escapeXmlAttribute(resOut)}/layout/fragment_${classToResource(className)}.xml" />

    <open file="${srcOut}/${className}ViewModel.kt"/>
</recipe>
