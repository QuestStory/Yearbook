import request from '@/utils/request'

// 查询同学列表
export function listClassmate(query) {
  return request({
    url: '/yearbook/classmate/list',
    method: 'get',
    params: query
  })
}

// 查询同学详细
export function getClassmate(id) {
  return request({
    url: '/yearbook/classmate/' + id,
    method: 'get'
  })
}

// 新增同学
export function addClassmate(data) {
  return request({
    url: '/yearbook/classmate',
    method: 'post',
    data: data
  })
}

// 修改同学
export function updateClassmate(data) {
  return request({
    url: '/yearbook/classmate',
    method: 'put',
    data: data
  })
}

// 删除同学
export function delClassmate(id) {
  return request({
    url: '/yearbook/classmate/' + id,
    method: 'delete'
  })
}
