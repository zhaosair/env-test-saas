import IBtn from "@/components/ImageButton"
import useBreadcrumb from "@/framework/useBreadcrumb"
import { ChildrenFormSvg, FieldTemplateSvg, FormSvg, WorkSvg } from "./public/svg";
export default function (){
    useBreadcrumb([
        { title: '首页', path: '/' },
        { title: '管理员选项',path:"/designpage/config"},
    ]);
    // 默认一行四个
    return <div class="FlexBox">
        <IBtn url="/" OptionUrl="/" color="#00897b" svg={
            <WorkSvg width="2vw" height="2vw" color="#fff"/>
        } Title="业务模型" SubTitle="业务模型"></IBtn>
        <IBtn url="/adminOptions/tableModel/tableModel-add" OptionUrl="/adminOptions/tableModel" color="#2196f3" svg={
            <FormSvg width="2vw" height="2vw" color="#fff"/>
        } Title="业务单表" SubTitle="业务单表"></IBtn>
        <IBtn url="/adminOptions/subTableModel/subTableModel-add" OptionUrl="/adminOptions/subTableModel" color="#ffb74d" svg={
            <ChildrenFormSvg width="2vw" height="2vw" color="#fff"/>
        } Title="子表模板" SubTitle="标准单表子表模板"></IBtn>
        <IBtn url="/fieldTemplate" OptionUrl="/fieldTemplate" color="#FB4508" svg={
            <FieldTemplateSvg width="2vw" height="2vw" color="#fff"/>
        } Title="字段模板" SubTitle="字段模板设计"></IBtn>
</div>
}