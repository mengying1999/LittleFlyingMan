package com.lfm.web.controller.activity;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import com.github.tobato.fastdfs.proto.storage.DownloadByteArray;
import com.lfm.common.core.domain.model.LoginUser;
import com.lfm.common.utils.ServletUtils;
import com.lfm.common.utils.StringUtils;
import com.lfm.common.utils.file.FastDFSUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.lfm.common.annotation.Log;
import com.lfm.common.core.controller.BaseController;
import com.lfm.common.core.domain.AjaxResult;
import com.lfm.common.enums.BusinessType;
import com.lfm.activity.domain.ActPrint;
import com.lfm.activity.service.IActPrintService;
import com.lfm.common.utils.poi.ExcelUtil;
import com.lfm.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

/**
 * 打印订单Controller
 *
 * @author zjz
 * @date 2020-11-09
 */
@Api("打印订单管理")
@RestController
@RequestMapping("/activity/print")
public class ActPrintController extends BaseController
{
    @Autowired
    private IActPrintService actPrintService;


    @Autowired
    private FastDFSUtils fastDFSUtils;
    /**
     * 查询打印订单列表
     */
    @ApiOperation("获取打印订单列表")
    @PreAuthorize("@ss.hasPermi('activity:print:list')")
    @GetMapping("/list")
    public TableDataInfo list(ActPrint actPrint)
    {
        startPage();
        List<ActPrint> list = actPrintService.selectActPrintList(actPrint);
        return getDataTable(list);
    }

    /**
     * 导出打印订单列表
     */
    @ApiOperation("导出打印订单列表")
    @PreAuthorize("@ss.hasPermi('activity:print:export')")
    @Log(title = "打印订单", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ActPrint actPrint)
    {
        List<ActPrint> list = actPrintService.selectActPrintList(actPrint);
        ExcelUtil<ActPrint> util = new ExcelUtil<ActPrint>(ActPrint.class);
        return util.exportExcel(list, "print");
    }

    /**
     * 获取打印订单详细信息
     */
    @ApiOperation("获取打印订单详细信息")
    @PreAuthorize("@ss.hasPermi('activity:print:query')")
    @GetMapping(value = "/{printId}")
    public AjaxResult getInfo(@PathVariable("printId") Long printId)
    {
        return AjaxResult.success(actPrintService.selectActPrintById(printId));
    }

    /**
     * 新增打印订单
     */
    @ApiOperation("新增打印订单")
    @PreAuthorize("@ss.hasPermi('activity:print:add')")
    @Log(title = "打印订单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ActPrint actPrint)
    {
        return toAjax(actPrintService.insertActPrint(actPrint));
    }

    /**
     * 修改打印订单
     */
    @ApiOperation("修改打印订单")
    @PreAuthorize("@ss.hasPermi('activity:print:edit')")
    @Log(title = "打印订单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ActPrint actPrint)
    {
        return toAjax(actPrintService.updateActPrint(actPrint));
    }

    /**
     *  修改为打印状态
     */
    @ApiOperation("修改为打印状态")
    @PreAuthorize("@ss.hasPermi('activity:print:edit')")
    @Log(title = "修改为打印状态", businessType = BusinessType.UPDATE)
    @PutMapping("editPrintStatus")
    public AjaxResult editPrintStatus(@RequestBody ActPrint actPrint)
    {
        return toAjax(actPrintService.updatePrintStatus(actPrint));
    }

    /**
     * 修改为配送状态
     */
    @ApiOperation("修改为配送状态")
    @PreAuthorize("@ss.hasPermi('activity:print:edit')")
    @Log(title = "修改为配送状态", businessType = BusinessType.UPDATE)
    @PutMapping("editDeliveryStatus")
    public AjaxResult editDeliveryStatus(@RequestBody ActPrint actPrint)
    {
        return toAjax(actPrintService.updateDeliveryStatus(actPrint));
    }

    /**
     * 修改为完成状态
     */
    @ApiOperation("修改为完成状态")
    @PreAuthorize("@ss.hasPermi('activity:print:edit')")
    @Log(title = "修改为完成状态", businessType = BusinessType.UPDATE)
    @PutMapping("editFinishStatus")
    public AjaxResult editFinishStatus(@RequestBody ActPrint actPrint)
    {
        return toAjax(actPrintService.updateFinishStatus(actPrint));
    }

    /**
     * 修改为完成状态
     */
    @ApiOperation("取消订单")
    @PreAuthorize("@ss.hasPermi('activity:print:edit')")
    @Log(title = "取消订单", businessType = BusinessType.UPDATE)
    @PutMapping("editCancelStatus")
    public AjaxResult editCancelStatus(@RequestBody ActPrint actPrint)
    {
        return toAjax(actPrintService.updateCancelStatus(actPrint));
    }

    /**
     * 删除打印订单
     */
    @ApiOperation("删除打印订单")
    @PreAuthorize("@ss.hasPermi('activity:print:remove')")
    @Log(title = "打印订单", businessType = BusinessType.DELETE)
    @DeleteMapping("/{printIds}")
    public AjaxResult remove(@PathVariable Long[] printIds)
    {
        return toAjax(actPrintService.deleteActPrintByIds(printIds));
    }

    /**
     * 单文件下载
     * @param id
     * @param httpServletResponse
     * @throws MalformedURLException
     */
    @ApiOperation("文件下载")
    @Log(title = "文件下载", businessType = BusinessType.UPDATE)
    @GetMapping(value = "/download/{id}")
    public void downloadFilesWithFastdfs(@PathVariable Long id, HttpServletResponse httpServletResponse) throws MalformedURLException {
        //操作数据库，读取文件上传时的信息
        ActPrint print = actPrintService.selectActPrintById(id);
        if(print!=null){
            try {
                String fileName = print.getFileName();
                String fileUrl = print.getFileUrl();
                String filepath = fileUrl.substring(fileUrl.lastIndexOf("group1/")+7);
                DownloadByteArray callback = new DownloadByteArray();
                byte[] b = fastDFSUtils.downloadFile(fileUrl);
                httpServletResponse.reset();
                httpServletResponse.setContentType("application/x-download");
                httpServletResponse.addHeader("Content-Disposition" ,"attachment;filename=\"" +fileName+ "\"");
                httpServletResponse.getOutputStream().write(b);
                httpServletResponse.getOutputStream().close();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
