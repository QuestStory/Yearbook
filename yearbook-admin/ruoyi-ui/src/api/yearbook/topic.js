import request from '@/utils/request'

// 查询话题列表
export function listTopic(query) {
  return request({
    url: '/yearbook/topic/list',
    method: 'get',
    params: query
  })
}

// 查询话题详细
export function getTopic(id) {
  return request({
    url: '/yearbook/topic/' + id,
    method: 'get'
  })
}

// 新增话题
export function addTopic(data) {
  return request({
    url: '/yearbook/topic',
    method: 'post',
    data: data
  })
}

// 修改话题
export function updateTopic(data) {
  return request({
    url: '/yearbook/topic',
    method: 'put',
    data: data
  })
}

// 删除话题
export function delTopic(id) {
  return request({
    url: '/yearbook/topic/' + id,
    method: 'delete'
  })
}
