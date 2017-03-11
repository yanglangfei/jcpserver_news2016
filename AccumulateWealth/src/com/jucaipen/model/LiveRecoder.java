package com.jucaipen.model;

/**
 * @author ���ʷ�
 *2017��3��11��  ����11:26:27
 *
 *   ֱ����¼
 */
public class LiveRecoder {
	/**
	 *  id
	 */
	private int id;
	
	/**
	 *   ֱ��id
	 */
	private int liveId;
	
	/**
	 *   ��ʦid
	 */
	private int teacherId;
	
	/**
	 *   ֱ�����
	 */
	private String liveNo;
	
	/**
	 *   ��ʼʱ��
	 */
	private String startDate;
	
	/**
	 *   ֱ��״̬  (1   ����ֱ��     2   �Ѿ�����)
	 */
	private int liveState;
	
	/**
	 *    ֱ������ʱ��
	 */
	private String endDate;
	
	/**
	 *   ��ע
	 */
	private String remark;
	
	

	public LiveRecoder(int id, int liveId, int teacherId, String liveNo,
			String startDate, int liveState, String endDate, String remark) {
		this.id = id;
		this.liveId = liveId;
		this.teacherId = teacherId;
		this.liveNo = liveNo;
		this.startDate = startDate;
		this.liveState = liveState;
		this.endDate = endDate;
		this.remark = remark;
	}

	public int getLiveId() {
		return liveId;
	}



	public void setLiveId(int liveId) {
		this.liveId = liveId;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public String getLiveNo() {
		return liveNo;
	}

	public void setLiveNo(String liveNo) {
		this.liveNo = liveNo;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public int getLiveState() {
		return liveState;
	}

	public void setLiveState(int liveState) {
		this.liveState = liveState;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
